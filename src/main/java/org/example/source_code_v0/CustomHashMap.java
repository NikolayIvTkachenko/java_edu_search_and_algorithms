package org.example.source_code_v0;

import java.util.List;
import java.util.Map;

public class CustomHashMap<K, V> extends CustomBetterMap<K, V> implements Map<K, V>{

    protected static final double FACTOR = 1.0;

    @Override
    public V put(K key, V value) {
        V oldValue = super.put(key, value);

        //System.out.println("Put " + key + " in " + map + " size now " + map.size());

        // check if the number of elements per map exceeds the threshold
        if (size() > maps.size() * FACTOR) {
            rehash();
        }
        return oldValue;
    }

    protected void rehash() {
        // save the existing entries
        List<CustomLinearMap<K, V>> oldMaps = maps;

        // make more maps
        int newK = maps.size() * 2;
        makeMaps(newK);

        //System.out.println("Rehashing, n is now " + newN);

        // put the entries into the new map
        for (CustomLinearMap<K, V> map: oldMaps) {
            for (Map.Entry<K, V> entry: map.getEntries()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new CustomHashMap<String, Integer>();
        for (int i=0; i<10; i++) {
            map.put(new Integer(i).toString(), i);
        }
        Integer value = map.get("3");
        System.out.println(value);
    }

}
