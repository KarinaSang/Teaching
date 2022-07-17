def is_bipartite(graph, src):
    # construct a colour array to store colours assigned to all vertices
    # -1 indicates no colour is assigned, 0 indicates first colour,
    # 1 indicates the second
    colour_arr = {node: -1 for node in graph};

    # assign first color to source
    colour_arr[src] = 0;

    # create a queue for graph traversal
    queue = [src];

    # run while there are vertices in queue
    # similar to BFS
    while queue:
        u = queue.pop();

        # return false if there is a self-loop
        # if u in graph[u]:
            # return False;

        for v in graph:
            # an edge from u to v exists and destination v is not coloured
            if (u in graph[v]) and (colour_arr[v] == -1):
                # assign an alternate colour to this adjacent v of u
                colour_arr[v] = 1 - colour_arr[u];
                queue.append(v);

            # an edge from u to v exists and destination v is coloured
            # with the same colour as u
            elif (u in graph[v]) and colour_arr[v] == colour_arr[u]:
                return False;

    return True;


g_not_bipartite = {0: {1, 2, 3},
     1: {0, 2},
     2: {1, 4},
     3: {0},
     4: {2}};

g_odd_cycle = {0: {1, 2},
               1: {1, 2},
               2: {0, 1}};

g_even_cycle = {0: {1, 3},
                1: {0, 2},
                2: {1, 3},
                3: {0, 2}};

print(is_bipartite(g_not_bipartite, 0))
print(is_bipartite(g_odd_cycle, 0))
print(is_bipartite(g_even_cycle, 0))

