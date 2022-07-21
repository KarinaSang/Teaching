# Counting sort in Python
MAX_NUMBER = 20;


def counting_sort(array):
    size = len(array);
    output = [0] * size;

    # Initialize count array
    count = [0] * MAX_NUMBER;

    # Store the count of each element in the count array
    for i in range(0, size):
        count[array[i]] += 1;

    # Store the cumulative count
    for i in range(1, MAX_NUMBER):
        count[i] += count[i - 1];

    # Find the index of each element of the original array
    # and place the elements in the output array
    i = size - 1;
    while i >= 0:
        output[count[array[i]] - 1] = array[i];
        count[array[i]] -= 1;
        i -= 1;

    # Copy sorted elements into the original array
    for i in range(0, size):
        array[i] = output[i];


data = [4, 2, 2, 18, 13, 13, 1, 16, 8]
counting_sort(data);
print("Sorted Array in Ascending Order: ");
print(data);
