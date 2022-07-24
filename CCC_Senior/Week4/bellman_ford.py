def print_dist(dist):
    print("Vertex Distance from Source")
    for i in range(V):
        print(i, dist[i])


def bellman_ford(graph, src):
    dist = [9e9] * V
    dist[src] = 0

    # Step 2: Relax all edges |V| - 1 times. A simple shortest
    # path from src to any other vertex can have at-most |V| - 1
    # edges
    for node in range(V-1):
        for s, d, w in graph:
            if dist[s] != 9e9 and dist[d] > dist[s] + w:
                dist[d] = dist[s] + w

    # Step 3: detect negative cycle
    # if value changes then we have a negative cycle in the graph
    # and we cannot find the shortest distances
    for s, d, w in graph:
        if dist[s] != 9e9 and dist[d] > dist[s] + w:
            print("Graph contains negative weight cycle")
            return

    print_dist(dist)


V = 5
graph = [[0, 1, -1],
         [0, 2, 4],
         [1, 2, 3],
         [1, 3, 2],
         [1, 4, 2],
         [3, 2, 5],
         [3, 1, 1],
         [4, 3, -3]]

bellman_ford(graph, 0)

negative_weight_cycle = [[0, 1, -1],
         [0, 2, 4],
         [1, 2, 3],
         [1, 3, 2],
         [1, 4, -2],
         [3, 2, 5],
         [3, 1, 1],
         [4, 3, -3]]

bellman_ford(negative_weight_cycle, 0)
