
import java.util.*;

public class Solution {
    public static boolean isLeaf(TreeNode node){
        return (node.left==null && node.right==null);
    }
    public static void addLeftBoundary(TreeNode root,List<Integer> res){
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    public static void addLeaves(TreeNode root, List<Integer> res) {
        if(root==null) return;
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        addLeaves(root.left,res);
        addLeaves(root.right,res);
    }
    public static void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null) {
            if (!isLeaf(curr)) temp.add(curr.val);
            if (curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--) {
            res.add(temp.get(i));
        }
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        if(!isLeaf(root)) res.add(root.val);
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
}