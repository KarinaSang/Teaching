def lcs_tabulation(X, Y, m, n, L):
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                L[i][j] = 0
            elif X[i - 1] == Y[j - 1]:
                L[i][j] = L[i - 1][j - 1] + 1
            else:
                L[i][j] = max(L[i - 1][j], L[i][j - 1])

    # L[m][n] contains the length of LCS of X[0..n-1] & Y[0..m-1]
    return L[m][n]


X = [50, 3, 10, 7, 40, 80]
Y = sorted(X)
m = len(X)
n = len(Y)
L = [[None]*(n+1) for i in range(m+1)]

print(lcs_tabulation(X, Y, m, n, L))

