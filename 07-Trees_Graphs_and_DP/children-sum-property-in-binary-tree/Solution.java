class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

public class Solution {
    public static void changeTree(BinaryTreeNode root) {
        if(root==null) return;
        int childSum=0;
        if(root.left!=null) childSum+=root.left.data;
        if(root.right!=null) childSum+=root.right.data;
        if(childSum>=root.data) root.data=childSum;
        if(childSum<root.data){
            if(root.left!=null) root.left.data=root.data;
            if(root.right!=null) root.right.data=root.data;
        }
        //recursionnnn!!
        changeTree(root.left);
        changeTree(root.right);
        //backktrackingg!!
        int totalSum=0;
        if(root.left!=null) totalSum+=root.left.data;
        if(root.right!=null) totalSum+=root.right.data;

        if(root.left!=null || root.right!=null) root.data=totalSum;
    }
}