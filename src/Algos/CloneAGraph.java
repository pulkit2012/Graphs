package Algos;

import java.util.HashMap;
import java.util.List;

public class CloneAGraph {
    static class Node{
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
        }
    }
    //DFS Approach
    public Node cloneGraph(Node node) {
        HashMap<Integer,Node> map = new HashMap<>();
        return dfs(node,map);
    }
    static Node dfs(Node node, HashMap<Integer,Node> map){
        if(node == null){
            return node;
        }
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node currNode = new Node(node.val);
        map.put(node.val, currNode);
        for(Node neighbor: node.neighbors) {
            currNode.neighbors.add(dfs(neighbor, map));
        }

        return currNode;
    }
}
