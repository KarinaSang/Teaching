# Different types of tuples

def tuple_samples():
    # Empty tuple
    my_tuple = ()
    print(my_tuple)

    # Tuple having integers
    my_tuple = (1, 2, 3)
    print(my_tuple)

    # tuple with mixed datatypes
    my_tuple = (1, "Hello", 3.4)
    print(my_tuple)

    # nested tuple
    my_tuple = ("mouse", [8, 4, 6], (1, 2, 3))
    print(my_tuple)


# accessing tuple elements using indexing
def tuple_index():
    my_tuple = ('p', 'e', 'r', 'm', 'i', 't')

    print(my_tuple[0])
    print(my_tuple[5])
    # print(my_tuple[6])

    # nested tuple
    n_tuple = ("mouse", [8, 4, 6], (1, 2, 3))
    # nested index
    print(n_tuple[0][3])
    print(n_tuple[1][1])


def tuple_negative_index():
    my_tuple = ('p', 'e', 'r', 'm', 'i', 't')

    print(my_tuple[-1])

    print(my_tuple[-6])


def tuple_slicing():
    # Accessing tuple elements using slicing
    my_tuple = ('p', 'r', 'o', 'g', 'r', 'a', 'm', 'i', 'z')

    # elements 2nd to 4th
    # Output: ('r', 'o', 'g')
    print(my_tuple[1:4])

    # elements beginning to 2nd
    # Output: ('p', 'r')
    print(my_tuple[:-7])

    # elements 8th to end
    # Output: ('i', 'z')
    print(my_tuple[7:])

    # elements beginning to end
    # Output: ('p', 'r', 'o', 'g', 'r', 'a', 'm', 'i', 'z')
    print(my_tuple[:])


def tuple_change_value():
    # Changing tuple values
    my_tuple = (4, 2, 3, [6, 5])

    # TypeError: 'tuple' object does not support item assignment
    # my_tuple[1] = 9

    # However, item of mutable element can be changed
    my_tuple[3][0] = 9
    print(my_tuple)

    # Tuples can be reassigned
    my_tuple = ('p', 'r', 'o', 'g', 'r', 'a', 'm', 'i', 'z')

    print(my_tuple)


def tuple_concatenation():
    # Concatenation
    print((1, 2, 3) + (4, 5, 6))

    # Repeat
    print(("Repeat",) * 3)


def tuple_methods():
    my_tuple = ('a', 'p', 'p', 'l', 'e',)

    print(my_tuple.count('p'))  # Output: 2
    print(my_tuple.index('l'))  # Output: 3


def tuple_membership():
    # Membership test in tuple
    my_tuple = ('a', 'p', 'p', 'l', 'e',)

    # In operation
    print('a' in my_tuple)
    print('b' in my_tuple)

    # Not in operation
    print('g' not in my_tuple)


def tuple_iteration():
    # Using a for loop to iterate through a tuple
    for name in ('John', 'Kate'):
        print("Hello", name)


tuple_iteration()


