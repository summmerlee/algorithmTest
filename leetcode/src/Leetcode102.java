import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 用的BFS
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root==null) return res;
            List<Integer> first = new ArrayList<Integer>();
            first.add(root.val);
            res.add(first);
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> sub = new ArrayList<>();
                int temp = queue.size();
                for(int i=0;i<temp;i++){
                    TreeNode now = queue.poll();
                    if(now.left!=null){
                        sub.add(now.left.val);
                        queue.offer(now.left);
                    }
                    if(now.right!=null){
                        sub.add(now.right.val);
                        queue.offer(now.right);
                    }
                }
                if(sub!=null && sub.size()!=0)
                    res.add(sub);
            }
            return res;
        }
    }
}
