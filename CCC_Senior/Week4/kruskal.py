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


def kruskal(graph):
    mst = []
    graph = sorted(graph, key=lambda item: item[2])
    parent = []
    rank = []
    i, e = 0, 0

    for node in range(V):
        parent.append(node)
        rank.append(0)

    while e < V-1:
        u, v, w = graph[i]
        i += 1
        u_root = find(parent, u)
        v_root = find(parent, v)

        if u_root != v_root:
            e += 1
            mst.append([u, v, w])
            union(parent, rank, u_root, v_root)

    return mst


V = 6
graph = [[0, 1, 4],
         [0, 2, 4],
         [1, 2, 2],
         [1, 0, 4],
         [2, 0, 4],
         [2, 1, 2],
         [2, 3, 3],
         [2, 5, 2],
         [2, 4, 4],
         [3, 2, 3],
         [3, 4, 3],
         [4, 2, 4],
         [4, 3, 3],
         [5, 2, 2],
         [5, 4, 3]]

print(kruskal(graph))
