def dfs(graph, start, visited):
    visited.add(start);

    print(start);

    for neighbour in graph[start]:
        if neighbour not in visited:
            dfs(graph, neighbour, visited);

    return visited;


g = {'0': {'1', '2', '3'},
     '1': {'0', '2'},
     '2': {'0', '4'},
     '3': {'0'},
     '4': {'2'}}
visited = set()
dfs(g, '0', visited);
