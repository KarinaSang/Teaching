a = 6 # 0110
b = 2 # 0010


def bit_example():
    print(a & b) # 0010
    print(a | b) # 0110
    print(a ^ b) # 0100
    print(~a) # -(x+1)
    print(a << 1) # shift left one digit 01100
    print(a >> 2) # shift right two digits  0001


def check_even_odd(n):
    return n & 1


def set_bit(n, pos):
    # (1 << pos) will shift 1 to pos
    return n | (1 << pos)


def unset_bit(n, pos):
    return n & (~(1 << pos))


def toggle_bit(n, pos):
    return n ^ (1 << pos)


def check_bit(n, pos):
    return n & (1 << pos)


def clear_bits(n, pos):
    return n & (~((1 << pos+1) - 1))


# print(bit_example())
print(check_even_odd(1290957492))
print(set_bit(a, 3))
#print(unset_bit(a, 1))
#print(toggle_bit(a, 0))
#print(toggle_bit(a, 1))
#print(check_bit(a, 0))

n = 93.7
print(n // 2)
print(int(n) >> 1)

