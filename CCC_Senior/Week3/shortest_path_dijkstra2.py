from heapq import *;


def dijkstra(graph, src, dest):
    queue = [(0, src, ())];
    visited = [];
    dist[src] = 0;

    while queue:
        (cost, u, path) = heappop(queue);

        if u not in visited:
            visited.append(u);
            path = u, path;

            if u == dest:
                return cost, path;

            for cost, v in graph[u]:
                if v not in visited:
                    temp_distance = dist[u] + cost
                    if temp_distance < dist[v]:
                        dist[v] = temp_distance;
                        heappush(queue, (temp_distance, v, path))

    return float("inf"), None


g = {0: {(4, 1), (4, 2)},
     1: {(4, 0), (2, 2)},
     2: {(4, 0), (2, 1), (3, 3), (6, 4), (1, 5)},
     3: {(3, 2), (2, 4)},
     4: {(6, 2), (2, 3), (3, 5)},
     5: {(1, 2), (3, 4)}};


dist = [1000 for i in g];
result = dijkstra(g, 0, 4);
print("cost is ", result[0], "path is ", result[1]);
