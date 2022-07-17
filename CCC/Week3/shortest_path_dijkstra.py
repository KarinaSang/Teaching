def print_solution(src, dest):
    print('Distance is ', dist[dest])
    print('Shortest path is ');
    cur_node = dest;

    path = []
    while cur_node != src and cur_node != -1:
        path.append(cur_node);
        cur_node = prev[cur_node];
    path.append(src);

    print(path[::-1]);


def min_distance(graph, visited):
    min_index = 0;
    min_dist = 1000;

    for v in range(len(graph)):
        if dist[v] < min_dist and v not in visited:
            min_dist = dist[v];
            min_index = v;

    return min_index;


def dijkstra(graph, src):
    dist[src] = 0;
    visited = [];

    for node in graph:
        u = min_distance(graph, visited);

        # put the minimum distance vertex in the shortest path
        visited.append(u);

        # update dist value if current distance is greater than
        # the new distance adn the vertex is not already in the
        # shortest path
        for v in range(len(graph)):
            if (graph[u][v] > 0) and \
                    (v not in visited) and \
                    (dist[v] > dist[u] + graph[u][v]):
                dist[v] = dist[u] + graph[u][v];
                prev[v] = u;


g = [[0, 4, 4, 0, 0, 0],
     [4, 0, 2, 0, 0, 0],
     [4, 2, 0, 3, 6, 1],
     [0, 0, 3, 0, 2, 0],
     [0, 0, 6, 2, 0, 3],
     [0, 0, 1, 0, 3, 0]]

dist = [1000 for i in g];
prev = [-1 for i in g];


dijkstra(g, 0);
print(dist)
print(prev)
print_solution(0, 4)
print_solution(0, 2)


