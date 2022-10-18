# variables
num = 0
decimal = 9.6   #float
word = 'hello'
word = "hello"
bool_var = True
bool_var = False

# print function
# print(num)
# print(num, word, "hello world")
# print("not ending on a new line", end=" ")
# print("still on this line")
# print('cats', 'dogs', 'mice', end="", sep=', ')
# print(' are animals')


def input_example():
#    string = input()
#    print(string, type(string))
#    result = string + 5
#    print(result)
#    num = int(input())
#    print(num, type(num))
#    result = num + 5
#   print(result)
#    a, b = input().split()
#    a = int(a)
#    b = int(b)
#    print(a, " ", b, type(a))
#    a, b, c = map(int, input().split())
#    print(a, " ", b, " ", c, type(a))
    list = input().split()
    list.append(9)
    print(list)
    print("this is the end of input example")


def len_example():
    print(len("123"))
    print(len("hello"))
    list = [1, 2, 3, "hello"]
    print(len(list))


def bool_operator_example():
    print((4 > 3) and (5 > 1))
    print((4 < 3) or (4 > 3))
    print(not(4 < 3))
    print((4 < 3) and (5 > 3))
    some_bool = True
    some_bool2 = False
    print(not some_bool)
    print(not True)
    print(some_bool and some_bool2)
    print(some_bool or some_bool2)


def if_operator_example():
    num = 10
    if num > 5:
        print("number is greater than 5")
        print("one more line")
    elif num >= 0:
        print("number is not negative")
    else:
        print("number is negative")


def while_loop_example():
    count = 5
    while count >= 0:
        print(count)
        count -= 1
        # if count == 3:
            # break


def range_example():
    # 0, 1, 2, 3
    for i in range(4):
        print(i, end=" ")
    print()

    # 1, .... , 9
    for i in range(1, 10):
        print(i, end=" ")
    print()

    # 1, 3, 5, 7, 9
    for i in range(10, 0, -2):
        print(i, end=" ")
    print()


def for_loop_example():
    list = ["a", "b", "c", "d", 4, 9]
    for item in list:
        print(item)


def calculate_sum(a, b):
    return a+b


# input_example()
# len_example()
# bool_operator_example()
# if_operator_example()
# while_loop_example()
# range_example()
# for_loop_example()
print(calculate_sum(10.8, 11.8))
print(calculate_sum("hi", "sum"))
