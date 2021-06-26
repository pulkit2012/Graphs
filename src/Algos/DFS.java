package Algos;

import java.util.*;

public class DFS {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static void addDirectedEdge(HashMap<Integer, List<Edge>> graph, int from, int to, int cost) {
        List<Edge> list = graph.get(from);
        if(list == null){
            list = new ArrayList<Edge>();
            graph.put(from,list);
        }
        list.add(new Edge(from,to,cost));
    }

    static long DFS(int node, boolean[] visited, Map<Integer, List<Edge>> graph) {
        if (visited[node]) {
            return 0L;
        }
        visited[node] = true;
        long count = 1;
        List<Edge> edges = graph.get(node);
        if (edges != null) {
            for (Edge e : edges) {
                count += DFS(e.to, visited, graph);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int numNodes = 5;
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph,0,1,4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10);
        long nodeCount = DFS(0,new boolean[numNodes],graph);
        System.out.println(nodeCount);

    }
}
