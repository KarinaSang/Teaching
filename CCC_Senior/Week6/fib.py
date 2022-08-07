def fib(n):
    if n <= 1:
        return n

    return fib(n - 1) + fib(n - 2)


def fib_top_down(n, lookup):
    # base case
    if n <= 1:
        lookup[n] = n

    # if the value is not calculated previously then calculate it
    if lookup[n] is None:
        lookup[n] = fib(n - 1, lookup) + fib(n - 2, lookup)

    # return the value corresponding to that value of n
    return lookup[n]


def fib_bottom_up(n):
    # array declaration
    f = [0] * (n + 1)

    # base case assignment
    f[1] = 1

    # calculating the fibonacci and storing the values
    for i in range(2, n + 1):
        f[i] = f[i - 1] + f[i - 2]
    return f[n]

