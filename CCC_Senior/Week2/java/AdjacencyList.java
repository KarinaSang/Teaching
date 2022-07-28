package week2;

import java.util.*;

class AdjacencyList {

    // Add edge
    static void addEdge(LinkedList<Integer> adj[], int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }


    // Print the graph
    static void printGraph(LinkedList<Integer> adj[]) {
        for (int i = 0; i < adj.length; i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(" -> " + adj[i].get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create the graph
        int V = 5;
        LinkedList<Integer> adj[] = new LinkedList [V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);

        printGraph(adj);
    }

}

