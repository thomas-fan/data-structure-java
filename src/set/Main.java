package set;

import utils.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
       statistic("pride-and-prejudice.txt");
       statistic("a-tale-of-two-cities.txt");
    }

    private static void statistic(String path) {
        System.out.println(path);
        ArrayList<String > words = new ArrayList<>();
        if (FileOperation.readFile(path, words)) {
            System.out.println("Total words: " + words.size());
            LinkedListSet<String > set = new LinkedListSet<>();
            for (String word: words) {
                set.add(word);
            }

            System.out.println("Total different word: " + set.getSize());
        }
    }
}
