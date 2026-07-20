import java.util.*;

class Solution {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root = new Node();
    HashMap<String, Boolean> memo = new HashMap<>();

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public boolean solve(String s) {

        if (s.length() == 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {

            if (search(s.substring(0, i)) && solve(s.substring(i))) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        // Build Trie
        for (String word : wordDict) {
            insert(word);
        }

        return solve(s);
    }
}