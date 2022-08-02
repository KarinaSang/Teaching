INF = 9e9
V = 9
G = [[0, 4, 0, 0, 0, 0, 0, 8, 0],
     [4, 0, 8, 0, 0, 0, 0, 11, 0],
     [0, 8, 0, 7, 0, 4, 0, 0, 2],
     [0, 0, 7, 0, 9, 14, 0, 0, 0],
     [0, 0, 0, 9, 0, 10, 0, 0, 0],
     [0, 0, 4, 14, 10, 0, 2, 0, 0],
     [0, 0, 0, 0, 0, 2, 0, 1, 6],
     [8, 11, 0, 0, 0, 0, 1, 0, 7],
     [0, 0, 2, 0, 0, 0, 6, 7, 0]]

mst_set = set()
parent = [-1] * V
keys = [INF] * V


def print_mst():
    print("Edge \tWeight")
    for i in range(1, V):
        print(parent[i], "-", i, "\t", G[i][parent[i]])


def find_min():
    min_value = INF
    min_vertex = 0
    for i in range(V):
        if i not in mst_set and keys[i] < min_value:
            min_value = keys[i]
            min_vertex = i

    return min_vertex


def prim(start):
    keys[start] = 0

    while len(mst_set) != V:
        u = find_min()
        mst_set.add(u)

        for v in range(V):
            if G[u][v] != 0 and v not in mst_set and G[u][v] < keys[v]:
                keys[v] = G[u][v]
                parent[v] = u


prim(0)
print_mst()
