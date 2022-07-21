from collections import Counter
import heapq


# Code to find top 3 elements and their counts
# using most_common
def counter_example():
    arr = [1, 3, 4, 1, 2, 1, 1, 3, 4, 3, 5, 1, 2, 5, 3, 4, 5]
    counter = Counter(arr)
    top_three = counter.most_common(3)
    print(top_three)


# Python code to find 3 largest and 4 smallest
# elements of a list.
def heapq_example():
    grades = [110, 25, 38, 49, 20, 95, 33, 87, 80, 90]
    print(heapq.nlargest(3, grades))
    print(heapq.nsmallest(4, grades))
    grades2 = [90, 90, 90, 90, 90]
    print(heapq.nlargest(3, grades2))


def dictionary_zipping_example():
    stocks = {
        'Goog': 520.54,
        'FB': 76.45,
        'yhoo': 39.28,
        'AMZN': 306.21,
        'APPL': 99.76
    }

    zipped_1 = zip(stocks.values(), stocks.keys())

    # sorting according to values
    print(sorted(zipped_1))

    zipped_2 = zip(stocks.keys(), stocks.values())
    # sorting according to keys
    print(sorted(zipped_2))


def mapping():
    # Python code to apply a function on a list
    income = [10, 30, 75]

    def double_money(dollars):
        return dollars * 2

    new_income = list(map(double_money, income))
    print(new_income)


def string_concatenation():
    string = ""
    lst = ["Hello", "World", "Bye"]
    string = ' '.join(lst)
    print(string)

