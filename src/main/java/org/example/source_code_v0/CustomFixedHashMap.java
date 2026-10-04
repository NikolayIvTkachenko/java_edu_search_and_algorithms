package org.example.source_code_v0;


import java.util.Map;


public class CustomFixedHashMap<K, V> extends CustomHashMap<K, V> implements Map<K, V> {


    private int size = 0;

    @Override
    public void clear() {
        super.clear();
        size = 0;
    }


    @Override
    public V put(K key, V value) {
        CustomLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.put(key, value);
        size += map.size();

        if (size() > maps.size() * FACTOR) {
            size = 0;
            rehash();
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        CustomLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.remove(key);
        size += map.size();
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new CustomFixedHashMap<String, Integer>();
        for (int i=0; i<10; i++) {
            map.put(new Integer(i).toString(), i);
        }
        Integer value = map.get("3");
        System.out.println(value);
    }

}
