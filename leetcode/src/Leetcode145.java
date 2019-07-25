import java.util.ArrayList;
import java.util.List;

public class Leetcode145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root==null) return res;
            if(root.left!=null)
                res.addAll(postorderTraversal(root.left));
            if(root.right!=null)
                res.addAll(postorderTraversal(root.right));
            res.add(root.val);
            return res;
        }
    }
}
