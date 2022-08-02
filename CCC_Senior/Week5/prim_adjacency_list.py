import heapq

V = 9
parent = [-1] * V

G = {
    0: {1: 4, 7: 8},
    1: {0: 4, 2: 8, 7: 11},
    2: {1: 8, 3: 7, 5: 4, 8: 2},
    3: {2: 7, 4: 9, 5: 14},
    4: {3: 9, 5: 10},
    5: {2: 4, 3: 14, 4: 10, 6: 2},
    6: {5: 2, 7: 1, 8: 6},
    7: {0: 8, 1: 11, 6: 1, 8: 7},
    8: {2: 2, 6: 6, 7: 7}}


def print_mst():
    print("Edge \tWeight")
    for i in range(1, V):
        print(parent[i], "-", i, "\t", G[i][parent[i]])


def prim(start):
    mst_set = set()
    mst_set.add(start)
    edges = [
        (cost, start, v)
        for v, cost in G[start].items()
    ]
    heapq.heapify(edges)

    while edges:
        cost, u, v = heapq.heappop(edges)
        if v not in mst_set:
            mst_set.add(v)
            parent[v] = u
            for neighbour_v, cost in G[v].items():
                if neighbour_v not in mst_set:
                    heapq.heappush(edges, (cost, v, neighbour_v))

prim(0)
print_mst()
