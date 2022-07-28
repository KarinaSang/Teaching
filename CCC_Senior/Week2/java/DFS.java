package week2;

import java.io.*;
import java.util.*;

public class DFS {
    private int V;
    private LinkedList<Integer> adj[];

    DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }

    public void dfs(int start, boolean visited[]) {
        visited[start] = true;

        System.out.println(start);

        Iterator<Integer> i = adj[start].listIterator();

        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                dfs(n, visited);
            }
        }

    }

    public static void main(String[] args) {
        DFS graph = new DFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);
        graph.addEdge(3, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);

        boolean visited[] = new boolean[5];
        graph.dfs(0, visited);

    }
}
