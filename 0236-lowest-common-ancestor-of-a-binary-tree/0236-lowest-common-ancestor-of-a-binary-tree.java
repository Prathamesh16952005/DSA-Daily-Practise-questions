/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
         if(root==p||root==q){
            return root;
          }


        TreeNode lca= lowestCommonAncestor(root.left,p ,q);
        TreeNode Rca =lowestCommonAncestor(root.right,p,q);

        if(lca != null && Rca!=null){
            return root;
        }

        if(lca != null){
            return lca;
        }
        return Rca;
    }
}