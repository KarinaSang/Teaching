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


def lcs_memoization(X, Y, m, n, L):
    if m == 0 or n == 0:
        return 0

    if L[m][n] is not None:
        return L[m][n]

    if X[m - 1] == Y[n - 1]:
        L[m][n] = 1 + lcs_memoization(X, Y, m - 1, n - 1, L)
        return L[m][n]

    L[m][n] = max(lcs_memoization(X, Y, m, n - 1, L), lcs_memoization(X, Y, m - 1, n, L))
    return L[m][n]


def lcs(X, Y, m, n):
    if m == 0 or n == 0:
        return 0
    elif X[m - 1] == Y[n - 1]:
        return 1 + lcs(X, Y, m - 1, n - 1)
    else:
        return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n))


X = "AGGTAB"
Y = "GXTXAYB"
m = len(X)
n = len(Y)
L = [[None]*(n+1) for i in range(m+1)]

print("Length of LCS is ", lcs(X, Y, m, n))

