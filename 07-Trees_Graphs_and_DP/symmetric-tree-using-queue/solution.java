import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1==null && t2==null) continue;
            if(t1==null || t2==null || t1.val!=t2.val) return false;
            //outer mirror
            q.add(t1.left);
            q.add(t2.right);
            //inner mirror
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
