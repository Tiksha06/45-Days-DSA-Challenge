class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Morris Preorder Traversal
        TreeNode curr=root;
        List<Integer> preorder=new ArrayList<>();

        while(curr!=null){
            if(curr.left==null){
                preorder.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr; //create thread
                    preorder.add(curr.val);
                    curr=curr.left;
                }else{
                    prev.right=null; //delete thread
                    curr=curr.right;
                }
            }
        }
        return preorder;
    }
}
