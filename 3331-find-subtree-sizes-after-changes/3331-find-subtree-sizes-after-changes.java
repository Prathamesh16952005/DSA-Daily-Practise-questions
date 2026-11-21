
import java.util.*;

class Solution {

    List<Integer>[] tree;
    int[] newParent;
    int[] answer;
    char[] chars;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        chars = s.toCharArray();
        newParent = parent.clone();

        // Stores nearest ancestor for each character
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Find new parents using original tree
        dfsUpdate(0, last);

        // Build modified tree
        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        answer = new int[n];
        dfsSize(0, newTree);

        return answer;
    }

    private void dfsUpdate(int node, int[] last) {

        int c = chars[node] - 'a';

        int previous = last[c];

        // Update parent if matching ancestor exists
        if (node != 0 && previous != -1) {
            newParent[node] = previous;
        }

        // Save current node as nearest ancestor
        last[c] = node;

        // Visit original children
        for (int child : tree[node]) {
            dfsUpdate(child, last);
        }

        // Backtrack to restore ancestor information
        last[c] = previous;
    }

    private int dfsSize(int node, List<Integer>[] newTree) {

        int size = 1;

        for (int child : newTree[node]) {
            size += dfsSize(child, newTree);
        }

        answer[node] = size;

        return size;
    }
}
