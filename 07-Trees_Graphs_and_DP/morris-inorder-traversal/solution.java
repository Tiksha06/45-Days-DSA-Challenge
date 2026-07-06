class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer> inorder=new ArrayList<>();

        while(curr!=null){
            if(curr.left==null){
                inorder.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr; //create thread
                    curr=curr.left;
                }else{
                    prev.right=null; //delete thread
                    inorder.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return inorder;
    }
}
