def tabulation(a, max_set):
    ans = 0

    for i in range(len(a)):
        max_set[i] = a[i]
        for j in range(i-2):
            max_set[i] = max(max_set[i], max_set[i] + a[j])
        ans = max(ans, max_set[i])

    return ans


def memoization(a, i, max_set):
    if i == len(a):
        max_set[i] = 0
    if i > len(a):
        return 0

    if max_set[i] is None:
        keep = a[i] + maximum_independent_set(a, i+2)
        discard = maximum_independent_set(a, i+1)
        max_set[i] = max(keep, discard)

    return max_set[i]


def maximum_independent_set(a, i):
    if i > len(a)-1:
        return 0

    keep = a[i] + maximum_independent_set(a, i+2)
    discard = maximum_independent_set(a, i+1)
    return max(keep, discard)


a = [4, 5, 4, 1, 1, 8, 3, 5]
max_set = [None] * (len(a)+1)
print(maximum_independent_set(a, 0))
print(memoization(a, 0, max_set))
print(tabulation(a, max_set))
