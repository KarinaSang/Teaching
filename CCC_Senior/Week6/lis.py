# global variable to store the maximum

def lis(arr, n):
    # Base Case
    if n == 1:
        return 1

    # max_length is the length of LIS ending with arr[n-1]
    max_length = 1

    for j in range(1, n):
        res = lis(arr, j)
        if arr[j-1] < arr[n-1] and res + 1 > max_length:
            max_length = res + 1

    return max_length


def lis_tabulation(arr, n):
    LIS = [1] * n

    # Compute optimized LIS values in bottom up manner
    for i in range(1, n):
        for j in range(0, i):
            if arr[i] > arr[j] and LIS[i] < LIS[j] + 1:
                LIS[i] = LIS[j] + 1

    return max(LIS)


# Driver program to test the above function
arr = [10, 22, 9, 33, 21, 50, 41, 60]
n = len(arr)
print("Length of lis is ", lis(arr, n))

arr = [100, -9, 3, 4, 20, 6, 7]
n = len(arr)
print("Length of lis is ", lis(arr, n))

