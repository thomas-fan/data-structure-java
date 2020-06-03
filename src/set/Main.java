package set;

import utils.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
       statistic("pride-and-prejudice.txt", new BSTSet<String>());
       statistic("pride-and-prejudice.txt", new LinkedListSet<>());
//       statistic("a-tale-of-two-cities.txt", new BSTSet<String>());
    }

    private static void statistic(String path, Set<String> set) {
        long startTime = System.nanoTime();
        System.out.println(path);
        ArrayList<String > words = new ArrayList<>();
        if (FileOperation.readFile(path, words)) {
            System.out.println("Total words: " + words.size());
            for (String word: words) {
                set.add(word);
            }

            System.out.println("Total different word: " + set.getSize());
        }
        long endTime = System.nanoTime();
        System.out.println("运行时间为: " + (endTime - startTime)/ 1000000000.0 + "秒");
    }
}
