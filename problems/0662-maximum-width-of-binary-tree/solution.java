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
import java.util.*;

class Solution {
    static class Pair {
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx) {
            this.node=node;
            this.idx=idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().idx;
            int first=0,last=0;
            
            for(int i=0;i<size;i++){
                Pair curr = q.remove();
                int curr_idx = curr.idx - mmin;
                TreeNode node = curr.node;
                
                if(i==0) first=curr_idx;
                if(i==size - 1) last=curr_idx;
                
                if(node.left != null){
                    q.add(new Pair(node.left,2*curr_idx+1));
                }
                if(node.right!=null) {
                    q.add(new Pair(node.right,2*curr_idx+2));
                }
            }
            maxWidth=Math.max(maxWidth,last-first+1);
        }
        
        return maxWidth;
    }
}
