package Algos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleIUndirected {
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int vertices;

    static void graph(int vertices) {
        DetectCycleIUndirected.vertices = vertices;
        visited = new boolean[vertices];
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    static void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    static boolean isCycleUndirectedDFS(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        Integer adj;
        Iterator<Integer> iterator = adjList[vertex].listIterator();
        while (iterator.hasNext()) {
            adj = iterator.next();
            if (!visited[adj]) {
                if (isCycleUndirectedDFS(adj, visited, vertex)) {
                    return true;
                }
            } else if (adj != parent) {
                return true;
            }
        }
        return false;
    }

    static boolean isCyclicUndirectedDFSUtil() {
        int ver = DetectCycleIUndirected.vertices;
        for (int i = 0; i < ver; i++) {
            if (!visited[i]) {
                if (isCycleUndirectedDFS(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicUndirectedBFS(int vertices, int vertex, boolean[] visited) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int tempVertex = queue.poll();
            Iterator<Integer> iterator = adjList[vertex].listIterator();
            while (iterator.hasNext()) {
                int adj = iterator.next();
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                    parent[adj] = tempVertex;
                } else if (parent[tempVertex] != adj) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicUndirectedBFSUtil() {
        int len = DetectCycleIUndirected.vertices;
        visited = new boolean[len];
        Arrays.fill(visited, false);
        for (int i = 0; i < len; i++) {
            if (!visited[i] && isCyclicUndirectedBFS(len, i, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        graph(5);
        addEdge(1, 0);
        addEdge(0, 2);
        addEdge(2, 1);
        addEdge(0, 3);
        addEdge(3, 4);
        System.out.println(isCyclicUndirectedDFSUtil());
        System.out.println(isCyclicUndirectedBFSUtil());
    }
}
