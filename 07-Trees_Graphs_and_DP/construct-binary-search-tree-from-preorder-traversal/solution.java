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
    private int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder,Integer.MAX_VALUE);
    }
    private TreeNode buildBST(int[] preorder, int upperBound){
        if(i==preorder.length || preorder[i]>upperBound) return null;
        TreeNode root=new TreeNode(preorder[i++]);
        root.left=buildBST(preorder,root.val);
        root.right=buildBST(preorder,upperBound);
        return root;
    }
}
