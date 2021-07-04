package Algos;

import java.util.Iterator;
import java.util.LinkedList;

public class NoOfOperationsToMakeNetworkConnected {
    static boolean[] visited;
    static int vertices;
    static LinkedList<Integer>[] adjList;
    static int counter = 0;

    static void graph(int vertices) {
        NoOfOperationsToMakeNetworkConnected.vertices = vertices;
        visited = new boolean[vertices];
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    static void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        graph(n);
        for (int i = 0; i < connections.length; i++) {
            addEdge(connections[i][0], connections[i][1]);
        }
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                counter++;
                dfs(i);
            }
        }
        return counter - 1;

    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        Iterator<Integer> iterator = adjList[vertex].listIterator();
        while (iterator.hasNext()) {
            int adj = iterator.next();
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(makeConnected(6,arr));
    }
}