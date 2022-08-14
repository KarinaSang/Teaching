def tabulation(p, lookup):
    lookup[0] = 0

    for i in range(1, p+1):
        lookup[i] = 9e9
        if i >= 1:
            lookup[i] = min(lookup[i], lookup[i - 1] + 1)
        if i >= 2:
            lookup[i] = min(lookup[i], lookup[i - 2] + 1)
        if i >= 5:
            lookup[i] = min(lookup[i], lookup[i - 5] + 1)

    return lookup[p]

def memoization(p, lookup):
    if p == 0:
        lookup[p] = 0
    if p < 0:
        return 9e9

    if lookup[p] is None:
        lookup[p] = 1 + min(memoization(p - 1, lookup), memoization(p - 2, lookup), memoization(p - 5, lookup))

    return lookup[p]


def coin_change(p):
    if p == 0:
        return 0
    if p < 0:
        return 9e9

    return 1 + min(coin_change(p - 1), coin_change(p - 2), coin_change(p - 5))


p = 11
lookup = [None] * (p+5)
print(coin_change(p))
# print(memoization(p, lookup))
print(tabulation(p, lookup))
