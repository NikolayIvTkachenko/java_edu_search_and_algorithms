package org.example.source_code_v0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class CustomTreeMapExample {

    public static void main(String[] args) {
        int n = 16384;
        System.out.println("\nTesting CustomTreeMap with random strings");
        putRandomStrings(n);

        System.out.println("\nTesting CustomTreeMap with timestamps");
        putTimestamps(n);
    }

    private static void putRandomStrings(int n) {
        // MyTreeMap<String, Integer> map = new MyTreeMap<String, Integer>();
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        final long startTime = System.currentTimeMillis();
        for (int i=0; i<n; i++) {
            String uuid = UUID.randomUUID().toString();
            map.put(uuid, 0);
        }
        final long elapsed = System.currentTimeMillis() - startTime;
        //printResults(map, elapsed, map.height());
        printResults(map, elapsed, -1);
    }

    private static void putTimestamps(int n) {
        //MyTreeMap<String, Integer> map = new MyTreeMap<String, Integer>();
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        final long startTime = System.currentTimeMillis();
        for (int i=0; i<n; i++) {
            String timestamp = Long.toString(System.nanoTime());
            map.put(timestamp, 0);
        }
        final long elapsed = System.currentTimeMillis() - startTime;
        //printResults(map, elapsed, map.height());
        printResults(map, elapsed, -1);
    }

    private static void printResults(Map<String, Integer> map, final long elapsed, int height) {
        System.out.println("    Time in milliseconds = " + (elapsed));
        System.out.println("    Final size of MyTreeMap = " + map.size());
        System.out.println("    log base 2 of size of MyTreeMap = " + Math.log(map.size()) / Math.log(2));
        System.out.println("    Final height of MyTreeMap = " + height);
    }

    @SuppressWarnings("unused")
    private static void putWordList(int n) {
        // assemble the file name
        String slash = File.separator;
        String filename = System.getProperty("user.dir") + slash +
                "src" + slash + "resources" + slash + "words.txt";

        CustomTreeMap<String, Integer> map = new CustomTreeMap<String, Integer>();

        final long startTime = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                map.put(line, 0);

                i++;
                if (i >= n) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long elapsed = System.currentTimeMillis() - startTime;
        printResults(map, elapsed, map.height());
    }

}
