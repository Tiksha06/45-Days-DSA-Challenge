class Solution {
    static class NodeInfo{
        TreeNode node;
        int row;
        int col;

        NodeInfo(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(root,0,0));
        while(!q.isEmpty()){
            NodeInfo packet=q.remove();
            TreeNode node=packet.node;
            int x =packet.col;
            int y =packet.row;
            if(!map.containsKey(x)) map.put(x,new TreeMap<>());
            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());
            map.get(x).get(y).add(node.val);

            if(node.left!=null){
                q.add(new NodeInfo(node.left,y+1,x-1));
            }
            if(node.right!=null){
                q.add(new NodeInfo(node.right,y+1,x+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> columnRowMap:map.values()){
            List<Integer> colList = new ArrayList<>();
            for(PriorityQueue<Integer> nodes:columnRowMap.values()){
                while(!nodes.isEmpty()){
                    colList.add(nodes.poll());
                }
            }
            ans.add(colList);
        }
        
        return ans;
    }
}


