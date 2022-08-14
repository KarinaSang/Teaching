def tabulation(n, lookup):
    lookup[0] = 1

    for i in range(1, n+1):
        lookup[i] = 0
        for j in range(1, 7):
            if i-j >= 0:
                lookup[i] += lookup[i-j]
                lookup[i] %= MOD

    return lookup[n]


def memoization(n, lookup):
    if n < 0:
        return 0
    if n == 0:
        lookup[n] = 1

    if lookup[n] is None:
        sum = 0
        for i in range(1, 7):
            if n-i >= 0:
                sum += memoization(n-i, lookup)
                sum %= MOD
        lookup[n] = sum

    return lookup[n]


def dice(n):
    if n < 0:
        return 0
    if n == 0:
        return 1

    sum = 0
    for i in range(1, 7):
        sum += dice(n-i)

    return sum


MOD = 1000000007
n = 4
lookup = [None] * (n+1)
# print(dice(n))
print(memoization(n, lookup))
print(tabulation(n, lookup))
