package Algos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static LinkedList<Integer> adjList[];
    static boolean[] visited;
    static void graph(int vertices){
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    static void addEdge(int src, int dest){
        adjList[src].add(dest);
    }
    static void BFS(int vertex){
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);
        while (!queue.isEmpty()){
            vertex = queue.poll();
            System.out.print(vertex + " ");
            Iterator<Integer> iterator = adjList[vertex].listIterator();
            while (iterator.hasNext()){
                int adj = iterator.next();
                if(!visited[adj]){
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        graph(4);
        addEdge(0,1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);
        BFS(2);
    }
}
