import java.util.*;
public class Solution {
    public static ArrayList<String> allRootToLeaf(BinaryTreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        
        getPath(root, currentPath, ans);
        return ans;
    }
    private static void getPath(BinaryTreeNode node,List<Integer> currentPath,List<String> ans){
        if(node==null) return;
        currentPath.add(node.data);

        if(node.left==null && node.right==null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<currentPath.size();i++) {
                sb.append(currentPath.get(i));
                if(i!=currentPath.size()-1){
                    sb.append(" ");
                }
            }
            ans.add(sb.toString());
        }else{ //recursionnn!
            getPath(node.left,currentPath,ans);
            getPath(node.right,currentPath,ans);
        }
        currentPath.remove(currentPath.size() - 1); //backtrakinggg!
    }
}
