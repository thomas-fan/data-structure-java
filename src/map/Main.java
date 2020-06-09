package map;

import utils.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(testMap(new BSTMap<String, Integer>(), "pride-and-prejudice.txt"));
        System.out.println(testMap(new LinkedListMap<String, Integer>(), "pride-and-prejudice.txt"));
    }
    private static double testMap(Map<String, Integer> map, String filename) {
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String > words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word: words) {
                if(map.contains(word) ) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
