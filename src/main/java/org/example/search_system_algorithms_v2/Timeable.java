package org.example.search_system_algorithms_v2;

import java.util.ArrayList;
import java.util.List;

public class Timeable {
    List<String> list;

    public Timeable() {}

    public void setup(int n) {
        list = new ArrayList<String>();
    }

    public void timeMe(int n) {
        for (int i = 0; i < n; i++) {
            list.add("a string");
        }
    }
}
