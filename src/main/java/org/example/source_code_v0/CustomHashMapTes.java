package org.example.source_code_v0;

import org.junit.Before;

public class CustomHashMapTes extends CustomLinearMapTest {

    @Before
    public void setUp() throws Exception {
        map = new CustomHashMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put(null, 0);
    }

}
