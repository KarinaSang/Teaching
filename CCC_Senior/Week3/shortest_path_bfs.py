def modified_BFS(graph, src, dest, dist, pred):
    queue = [];
    visited = [src];

    dist[src] = 0;
    queue.append(src);

    while queue:
        u = queue.pop(0);

        for v in graph[u]:
            if v not in visited:
                visited.append(v);
                dist[v] = dist[u] + 1;
                pred[v] = u;
                queue.append(v);

                if v == dest:
                    return True;

    return False;


def shortest_path(graph, src, dest):
    pred = [-1 for i in graph];
    dist = [-1 for i in graph];

    result = modified_BFS(graph, src, dest, dist, pred);

    if not result:
        print("Given source and destination are not connected");
        return;

    path = [];
    u = dest;
    path.append(u);

    while pred[u] != -1 and u != src:
        path.append(pred[u]);
        u = pred[u];

    print('Shortest path has a length of ' + str(dist[dest]));
    print('Shortest path is :');

    for i in range(len(path) - 1, -1, -1):
        print(path[i])


g = {0: {1, 3},
     1: {0, 2},
     2: {1},
     3: {0, 4, 7},
     4: {3, 5, 6},
     5: {4, 6},
     6: {4, 5, 7},
     7: {3, 4, 6}};

shortest_path(g, 0, 7);
shortest_path(g, 3, 6);
shortest_path(g, 4, 5);

# remove the edges that connect 0 to 7
g = {0: {1},
     1: {0, 2},
     2: {1},
     3: {4, 7},
     4: {3, 5, 6},
     5: {4, 6},
     6: {4, 5, 7},
     7: {3, 4, 6}};

shortest_path(g, 0, 7);
