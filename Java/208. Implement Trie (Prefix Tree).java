package Java;

import java.util.*;

class TrieNode {
    char value;
    Map<Character, TrieNode> next;
    boolean isEnd;

    TrieNode(char value) {
        this.value = value;
        this.next = new HashMap<>();
        isEnd = false;
    }

    TrieNode(char value, TrieNode[] next) {
        this.value = value;
        this.next = new HashMap<>();
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.next.putIfAbsent(c, new TrieNode(c));
            node = node.next.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next.get(c) != null) {
                node = node.next.get(c);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next.get(c) != null) {
                node = node.next.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */