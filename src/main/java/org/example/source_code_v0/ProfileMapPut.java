package org.example.source_code_v0;

import java.util.HashMap;
import java.util.Map;

import org.jfree.data.xy.XYSeries;


public class ProfileMapPut {

    public static void main(String[] args) {
        //profileHashMapPut();
        //profileMyHashMapPut();
        profileMyFixedHashMapPut();
    }

    public static void profileHashMapPut() {
        Profiler.Timeable timeable = new Profiler.Timeable() {
            Map<String, Integer> map;

            public void setup(int n) {
                map = new HashMap<String, Integer>();
            }

            public void timeMe(int n) {
                for (int i=0; i<n; i++) {
                    map.put(String.format("%10d", i), i);
                }
            }
        };
        int startN = 8000;
        int endMillis = 1000;
        runProfiler("HashMap put", timeable, startN, endMillis);
    }

    public static void profileMyHashMapPut() {
        Profiler.Timeable timeable = new Profiler.Timeable() {
            Map<String, Integer> map;

            public void setup(int n) {
                map = new CustomHashMap<String, Integer>();
            }

            public void timeMe(int n) {
                for (int i=0; i<n; i++) {
                    map.put(String.format("%10d", i), i);
                }
            }
        };
        int startN = 1000;
        int endMillis = 5000;
        runProfiler("MyHashMap put", timeable, startN, endMillis);
    }

    public static void profileMyFixedHashMapPut() {
        Profiler.Timeable timeable = new Profiler.Timeable() {
            Map<String, Integer> map;

            public void setup(int n) {
                map = new CustomFixedHashMap<String, Integer>();
            }

            public void timeMe(int n) {
                for (int i=0; i<n; i++) {
                    map.put(String.format("%10d", i), i);
                }
            }
        };
        int startN = 8000;
        int endMillis = 1000;
        runProfiler("MyFixedHashMap put", timeable, startN, endMillis);
    }

    private static void runProfiler(String title, Profiler.Timeable timeable, int startN, int endMillis) {
        Profiler profiler = new Profiler(title, timeable);
        XYSeries series = profiler.timingLoop(startN, endMillis);
        profiler.plotResults(series);
    }

}
