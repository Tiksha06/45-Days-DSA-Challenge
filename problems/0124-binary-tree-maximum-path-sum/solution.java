class Solution {
    private int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calcMaxPath(root);
        return maxSum;
    }
    private int calcMaxPath(TreeNode node){
        if(node==null) return 0;
        int leftMax=Math.max(0,calcMaxPath(node.left));
        int rightMax=Math.max(0,calcMaxPath(node.right));
        maxSum=Math.max(maxSum, node.val+leftMax+rightMax);
        return node.val+Math.max(leftMax,rightMax);
    }
}
