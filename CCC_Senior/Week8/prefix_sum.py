a = [1, 2, 3, 4, 5, 6, 7, 8]
n = len(a)
t = [None] * 4 * n


def sum(v, tl, tr, l, r):
    if l > r:
        return 0
    if l == tl and r == tr:
        return t[v]
    tm = int((tl + tr) / 2);
    return sum(v * 2, tl, tm, l, min(r, tm)) + \
           sum(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r)


def update(v, tl, tr, pos, new_val):
    if tl == tr:
        t[v] = new_val
    else:
        tm = int((tl + tr) / 2)
        if pos <= tm:
            update(v * 2, tl, tm, pos, new_val)
        else:
            update(v * 2 + 1, tm + 1, tr, pos, new_val)
        t[v] = t[v * 2] + t[v * 2 + 1]


def build(a, v, tl, tr):
    if tl == tr:
        t[v] = a[tl]
    else:
        tm = int((tl + tr) / 2)
        build(a, v * 2, tl, tm)
        build(a, v * 2 + 1, tm + 1, tr)
        t[v] = t[v * 2] + t[v * 2 + 1]


build(a, 1, 0, n - 1)
print(t)
update(1, 0, n - 1, 2, 8)
print(t)
print(sum(1, 0, n-1, 2, 5))
