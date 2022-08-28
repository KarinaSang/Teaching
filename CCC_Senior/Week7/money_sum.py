coins = int(input())
coin_values = list(map(int, input().split()))


def find_sum(coin_values, index, final_set):
    if index == 1:
        if coin_values[index] not in final_set:
            final_set.append(coin_values[index])
        return final_set

    else:
        old_set = find_sum(coin_values, index - 1, final_set)
        for value in old_set:
            if value not in final_set:
                final_set.append(value)
            if value + coin_values[index] not in final_set:
                final_set.append(value + coin_values[index])

        if coin_values[index] not in final_set:
            final_set.append(coin_values[index])

        return final_set


print(find_sum(coin_values, len(coin_values) - 1, list()))