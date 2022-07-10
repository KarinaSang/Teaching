def bfs(graph, start, visited):
    queue = [];
    visited.add(start);
    queue.append(start);

    while queue:
        m = queue.pop(0);
        print(m);

        for neighbour in graph[m]:
            if neighbour not in visited:
                visited.add(neighbour);
                queue.append(neighbour);


g = {'0': {'1', '2', '3'},
     '1': {'0', '2'},
     '2': {'0', '4'},
     '3': {'0'},
     '4': {'2'}}
visited = set()
bfs(g, '0', visited);
