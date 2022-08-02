V = 4
INF = 9e9
dist = [[0, INF, -2, INF],
        [4, 0, 3, INF],
        [INF, INF, 0, 2],
        [INF, -1, INF, 0]]


def floyd_warshall():
    # Adding vertices individually
    for k in range(V):
        for i in range(V):
            for j in range(V):
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])


floyd_warshall()
print(dist)
