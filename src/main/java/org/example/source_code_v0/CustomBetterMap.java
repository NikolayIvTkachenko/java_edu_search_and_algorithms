package org.example.source_code_v0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomBetterMap<K, V> implements Map<K, V> {

    protected List<CustomLinearMap<K, V>> maps;

    public CustomBetterMap() {
        makeMaps(2);
    }

    protected void makeMaps(int k) {
        maps = new ArrayList<CustomLinearMap<K, V>>(k);
        for (int i=0; i<k; i++) {
            maps.add(new CustomLinearMap<K, V>());
        }
    }

    @Override
    public void clear() {
        // clear the sub-maps
        for (int i=0; i<maps.size(); i++) {
            maps.get(i).clear();
        }
    }

    protected CustomLinearMap<K, V> chooseMap(Object key) {
        int index = key==null ? 0 : Math.abs(key.hashCode()) % maps.size();
        return maps.get(index);
    }

    @Override
    public boolean containsKey(Object target) {
        // to find a key, we only have to search one map
        CustomLinearMap<K, V> map = chooseMap(target);
        return map.containsKey(target);
    }

    @Override
    public boolean containsValue(Object target) {
        // to find a value, we have to search all map
        for (CustomLinearMap<K, V> map: maps) {
            if (map.containsValue(target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object key) {
        CustomLinearMap<K, V> map = chooseMap(key);
        return map.get(key);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Set<K> keySet() {
        // add up the keySets from the sub-maps
        Set<K> set = new HashSet<K>();
        for (CustomLinearMap<K, V> map: maps) {
            set.addAll(map.keySet());
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        CustomLinearMap<K, V> map = chooseMap(key);
        return map.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry: map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        CustomLinearMap<K, V> map = chooseMap(key);
        return map.remove(key);
    }

    @Override
    public int size() {
        // add up the sizes of the sub-maps
        int total = 0;
        for (CustomLinearMap<K, V> map: maps) {
            total += map.size();
        }
        return total;
    }

    @Override
    public Collection<V> values() {
        // add up the valueSets from the sub-maps
        Set<V> set = new HashSet<V>();
        for (CustomLinearMap<K, V> map: maps) {
            set.addAll(map.values());
        }
        return set;
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new CustomBetterMap<String, Integer>();
        map.put("Word1", 1);
        map.put("Word2", 2);
        Integer value = map.get("Word1");
        System.out.println(value);

        for (String key: map.keySet()) {
            System.out.println(key + ", " + map.get(key));
        }
    }
}
