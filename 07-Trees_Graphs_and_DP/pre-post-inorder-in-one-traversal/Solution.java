package 07-Trees_Graphs_and_DP.y;

import java.util.*;
public class Solution {
    static class Pair {
        TreeNode root;
        int state;

        Pair(TreeNode root, int state) {
            this.root=root;
            this.state=state;
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()){
            Pair node=st.peek();
            if(node.state==1){
                pre.add(node.root.data);
                node.state++;
                if(node.root.left!=null){
                    st.push(new Pair(node.root.left,1));
                }
            }else if(node.state==2){
                    in.add(node.root.data);
                    node.state++;
                    if(node.root.right!=null){
                        st.push(new Pair(node.root.right,1));
                    }
            }else{
                post.add(node.root.data);
                st.pop();
                }
        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}
