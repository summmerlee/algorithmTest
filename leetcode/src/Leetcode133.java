import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode133 {
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
    class Solution {
        public Node cloneGraph(Node node) {
            Map<Integer,Node> map = new HashMap<>();
            return dfs(node,map);
        }
        private Node dfs(Node node,Map<Integer,Node> map){
            if(node==null) return null;
            if(map.containsKey(node.val)) return map.get(node.val);
            Node copy = new Node(node.val, new ArrayList<Node>());
            map.put(node.val,copy);
            for(Node each:node.neighbors){
                copy.neighbors.add(dfs(each,map));
            }
            return copy;
        }
    }
}
