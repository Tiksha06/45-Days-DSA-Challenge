class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            inMap.put(inorder[i],i);
        }
        return splitTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }
    private TreeNode splitTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(preorder[preStart]);

        int inRoot=inMap.get(root.val); //index of root
        int numsLeft = inRoot-inStart; //elements of leftST

        root.left=splitTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,inMap);
        root.right=splitTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,inMap);

        return root;
    }
}
