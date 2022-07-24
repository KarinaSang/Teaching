# a utility function to find the subset of an element i
def find(parent, u):
    if parent[u] == u:
        return u
    else:
        return find(parent, parent[u])


# a utility function to do union of two subsets
def union(parent, u, v):
    u_root = find(parent, u)
    v_root = find(parent, v)
    parent[u_root] = v_root


def is_cyclic(graph):
    parent = []
    for node in range(V):
        parent.append(node)

    for u in graph:
        for v in graph[u]:
            u_root = find(parent, u)
            v_root = find(parent, v)

            if u_root == v_root:
                return True
            union(parent, u_root, v_root)

    return False


V = 3

# add edges to the undirected graph (add each edge once only to avoid
# detecting cycles among the same edges, say x -> y and y -> x)
graph = {0: [1, 2],
         1: [2],
         2: []}

print(is_cyclic(graph))

no_cycle = {0: [2],
            1: [2],
            2: []}

print(is_cyclic(no_cycle))
