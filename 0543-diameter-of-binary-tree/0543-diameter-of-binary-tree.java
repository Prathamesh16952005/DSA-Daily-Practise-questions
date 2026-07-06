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
    public static class info{
        int dia;
        int ht;
        public info(int dia, int ht){
            this.dia= dia;
            this.ht= ht;
        }
    
    } 
    public info helper(TreeNode root){
          if(root==null){
            return new info (0,0);
          }

          info leftinfo = helper(root.left);
          info rightinfo = helper(root.right);

          int ht = Math.max(leftinfo.ht,rightinfo.ht) + 1;

          int dia = Math.max( Math.max(leftinfo.dia,rightinfo.dia),leftinfo.ht+ rightinfo.ht);
            return new info(dia,ht);
    
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia;
    }
}