def topological_sort(graph):
    # construct indegrees map
    indegrees = {node: 0 for node in graph};
    for node in graph:
        for neighbour in graph[node]:
            indegrees[neighbour] += 1;

    # track nodes with no incoming edges
    nodes_with_no_incoming_edges = [];
    for node in graph:
        if indegrees[node] == 0:
            nodes_with_no_incoming_edges.append(node);

    topological_ordering = [];

    # as long as there are nodes with no incoming edges
    # that can be added to the ordering
    while len(nodes_with_no_incoming_edges) > 0:
        # add one of those nodes to the ordering
        node = nodes_with_no_incoming_edges.pop();
        topological_ordering.append(node);

        # decrement the indegree of that node's neighbours
        for neighbour in graph[node]:
            indegrees[neighbour] -= 1;
            if indegrees[neighbour] == 0:
                nodes_with_no_incoming_edges.append(neighbour);

    # all nodes with no incoming edges are added to topological ordering
    # verify if we added all nodes or there is a cycle
    if len(topological_ordering) == len(graph):
        return topological_ordering;
    else:
        raise Exception("Graph has a cycle! No topological ordering exists.")


g = {'0': {'1', '2', '3'},
     '1': {'2'},
     '2': {},
     '3': {},
     '4': {'2'}}

print(topological_sort(g));
