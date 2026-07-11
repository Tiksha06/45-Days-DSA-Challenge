
 import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }
public class solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        int successor=-1;
        int predecessor=-1;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.data>key){
                successor=curr.data;
                curr=curr.left;
            }else curr=curr.right;
        }
        curr=root;
        while(curr!=null){
            if(curr.data<key){
                predecessor=curr.data;
                curr=curr.right;
            }else curr=curr.left;
        }
        List<Integer> ans=new ArrayList<>();
        ans.add(predecessor);ans.add(successor);
        return ans;
    }
}