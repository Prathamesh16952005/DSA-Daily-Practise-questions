/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot, subRoot);
    }

    private boolean dfs(TreeNode node, TreeNode subNode, TreeNode subRoot){
        if(node == null && subNode == null) return true;
        if(node == null || subNode == null) return false;

        boolean value = false;

        if(node.val == subNode.val){
            value = dfs(node.left, subNode.left, subRoot) && dfs(node.right, subNode.right, subRoot);
        }
        if(value) return true;

        if(node.val == subRoot.val){
            value = dfs(node.left, subRoot.left, subRoot) && dfs(node.right, subRoot.right, subRoot);
        }
        if(value) return true;

        return dfs(node.left, subRoot, subRoot) || dfs(node.right, subRoot, subRoot);
    }
}