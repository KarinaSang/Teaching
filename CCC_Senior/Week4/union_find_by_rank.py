def find(parent, u):
    if parent[u] != u:
        parent[u] = find(parent, parent[u])
    return parent[u]


def union(parent, rank, u, v):
    u_root = find(parent, u)
    v_root = find(parent, v)

    # u, v already in the same set
    if u_root == v_root:
        return

    if rank[u_root] < rank[v_root]:
        parent[u_root] = v_root
    elif rank[u_root] > rank[v_root]:
        parent[v_root] = u_root
    else:
        parent[u_root] = v_root
        rank[v_root] += 1


def is_cyclic(graph):
    parent = []
    rank = []

    for node in range(V):
        parent.append(node)
        rank.append(0)

    for u in graph:
        for v in graph[u]:
            u_root = find(parent, u)
            v_root = find(parent, v)

            if u_root == v_root:
                return True
            union(parent, rank, u_root, v_root)

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
