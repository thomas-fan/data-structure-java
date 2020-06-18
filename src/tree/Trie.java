package tree;

import java.util.TreeMap;

public class Trie {
    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        Node() {
            this(false);
        }
    }

    private Node root;
    private Integer size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }

            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }

            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }

            cur = cur.next.get(c);
        }

        return true;
    }
}
