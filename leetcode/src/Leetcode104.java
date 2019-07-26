import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) return res;
            List<Integer> first = new ArrayList<Integer>();
            first.add(root.val);
            queue.offer(root);
            while (!queue.isEmpty()) {
                res++;
                int temp = queue.size();
                for (int i = 0; i < temp; i++) {
                    TreeNode now = queue.poll();
                    if (now.left != null) {
                        queue.offer(now.left);
                    }
                    if (now.right != null) {
                        queue.offer(now.right);
                    }
                }
            }
            return res;
        }
    }
}