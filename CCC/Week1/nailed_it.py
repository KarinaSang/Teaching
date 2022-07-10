# Getting input
N = int(input());
woods = input().split(' ');
count_wood = [0] * 2001;
count_board = [0] * 4001;

# Store the count of each wood in wood array
for wood in woods:
    count_wood[int(wood)] += 1;

# Store the count of possible boards in board array
for i in range(0, 2000):
    for j in range(i, 2001):
        if i == j:
            count_board[i + j] += count_wood[i] // 2;
        else:
            count_board[i + j] += min(count_wood[i], count_wood[j]);

longest, size = 0, 0;

# Find the longest fence
for board_length in count_board:
    if board_length > longest:
        longest = board_length;
        size = 1;
    elif board_length == longest:
        size += 1;

print(longest, size);

