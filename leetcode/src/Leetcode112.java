public class Leetcode112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 这个是我的解法 2ms
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root==null) return false;
            int num = 0;
            return dfs(root,sum, num);
        }

        private boolean dfs(TreeNode node, int sum, int num){
            if(node==null) return false;
            num = num+node.val;
            if(num==sum && node.right==null && node.left==null) return true;
            return dfs(node.left,sum,num) || dfs(node.right,sum,num);
        }
    }

    // 这个是网上一个人的写的好简单哦 然后她也2ms哈哈哈
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
