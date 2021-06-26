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
    // or another method
    static LinkedList<Integer> adjList[];
    static boolean visited[];
    static void Graph(int vertices){
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    static void addEdge(int src, int dest){
        adjList[src].add(dest);
    }
    static void DFS2(int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");
        Iterator<Integer> ite = adjList[vertex].listIterator();
        while (ite.hasNext()){
            int adj = ite.next();
            if(!visited[adj]){
                DFS2(adj);
            }
        }
        //For unconnected edge
        for (int i = 0; i < adjList.length; i++) {
            if(!visited[i]){
                DFS2(i);
            }
        }
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
        Graph(4);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,2);
        addEdge(2,0);
        addEdge(3,3);
        System.out.println("Traversal ");
        DFS2(0);

    }
}
