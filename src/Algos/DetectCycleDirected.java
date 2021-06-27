package Algos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class DetectCycleDirected {
    static LinkedList<Integer> adjList[];
    static int vertices;

    static void graph(int vertices) {
        DetectCycleDirected.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    static void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    static boolean dfsCycleDetector(int vertex, boolean[] visited, boolean[] recStack) {
        if (recStack[vertex]) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        recStack[vertex] = true;
        Iterator<Integer> iterator = adjList[vertex].listIterator();
        while (iterator.hasNext()) {
            int adj = iterator.next();
            if (dfsCycleDetector(adj, visited, recStack)) {
                return true;
            }
        }
        recStack[vertex] = false;
        return false;
    }

    static boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (dfsCycleDetector(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    //using BFS
    static void topologicalBFSCycleDetections() {
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            LinkedList<Integer> temp = adjList[i];
            for (int c : temp) {
                inDegree[c]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        Vector<Integer> topOrder = new Vector<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topOrder.add(u);
            for (int i : adjList[u]) {
                if (--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            count++;
        }
        System.out.println(count == vertices ? "No Cycle exist" : "Cycle Exist");
    }

    public static void main(String[] args) {
        graph(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        System.out.println(isCyclic());
        topologicalBFSCycleDetections();
    }
}
