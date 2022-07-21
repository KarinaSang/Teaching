def dictionary_example():
    # empty dictionary
    my_dict = {}

    # dictionary with integer keys
    my_dict = {1: 'apple', 2: 'ball'}

    # dictionary with mixed keys
    my_dict = {'name': 'John', 1: [2, 4, 3]}

    # using dict()
    my_dict = dict({1: 'apple', 2: 'ball'})

    # from sequence having each item as a pair
    my_dict = dict([(1, 'apple'), (2, 'ball')])


def dictionary_accessor():
    # get vs [] for retrieving elements
    my_dict = {'name': 'Jack', 'age': 26}

    # Output: Jack
    print(my_dict['name'])

    # Output: 26
    print(my_dict.get('age'))

    # Trying to access keys which doesn't exist throws error
    # Output None
    print(my_dict.get('address'))

    # KeyError
    # print(my_dict['address'])


def dictionary_modifier():
    # Changing and adding Dictionary Elements
    my_dict = {'name': 'Jack', 'age': 26}

    # update value
    my_dict['age'] = 27

    # Output: {'age': 27, 'name': 'Jack'}
    print(my_dict)

    # add item
    my_dict['address'] = 'Downtown'

    # Output: {'address': 'Downtown', 'age': 27, 'name': 'Jack'}
    print(my_dict)


def dictionary_deletion():
    # Removing elements from a dictionary

    # create a dictionary
    squares = {1: 1, 2: 4, 3: 9, 4: 16, 5: 25}

    # remove a particular item, returns its value
    # Output: 16
    print(squares.pop(4))

    # Output: {1: 1, 2: 4, 3: 9, 5: 25}
    print(squares)

    # remove an arbitrary item, return (key,value)
    # Output: (5, 25)
    print(squares.popitem())

    # Output: {1: 1, 2: 4, 3: 9}
    print(squares)

    # remove all items
    squares.clear()

    # Output: {}
    print(squares)

    # delete the dictionary itself
   # del squares

    # Throws Error
    # print(squares)


def dictionary_membership():
    # Membership Test for Dictionary Keys
    squares = {1: 1, 3: 9, 5: 25, 7: 49, 9: 81}

    # Output: True
    print(1 in squares)

    # Output: True
    print(2 not in squares)

    # membership tests for key only not value
    # Output: False
    print(49 in squares)


def dictionary_iteration():
    # Iterating through a Dictionary
    squares = {1: 1, 3: 9, 5: 25, 7: 49, 9: 81}
    for i in squares:
        print(i, squares[i])


dictionary_iteration()
