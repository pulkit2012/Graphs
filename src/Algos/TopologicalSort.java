package Algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TopologicalSort {
    static ArrayList<Integer> adjList[];
    static int vertices;
    static void graph(int vertices){
        TopologicalSort.vertices = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    static void addEdge(int src, int dest){
        adjList[src].add(dest);
    }
    static void topologicalSort(){
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            ArrayList<Integer> temp = adjList[i];
            for(int c : temp){
                inDegree[c]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        Vector<Integer> vector = new Vector<>();
        while (!queue.isEmpty()){
            int u = queue.poll();
            vector.add(u);
            for(int c : adjList[u]){
                if(--inDegree[c] == 0){
                    queue.add(c);
                }
            }
            count++;
        }
        System.out.println(vector);
    }
    public static void main(String[] args) {
        graph(6);
        addEdge(5, 2);
        addEdge(5, 0);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);
        topologicalSort();
    }
}
