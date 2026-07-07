class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        boolean leftToRight=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> currLevel=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode currNode=queue.poll();
                if(leftToRight) currLevel.add(currNode.val);
                if(!leftToRight) currLevel.add(0,currNode.val);

                if(currNode.left!=null) queue.add(currNode.left);
                if(currNode.right!=null) queue.add(currNode.right);
            }
            result.add(currLevel);
            leftToRight= !leftToRight;
        }
        return result;
    }
}
