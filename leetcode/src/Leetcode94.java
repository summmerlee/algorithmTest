import java.util.ArrayList;
import java.util.List;

public class Leetcode94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root==null) return list;
            dfs(root,list);
            return list;
        }
        private void dfs(TreeNode node, List<Integer> list){
            if(node.left!=null) dfs(node.left, list);
            list.add(node.val);
            if(node.right!=null) dfs(node.right, list);
        }
    }
}
