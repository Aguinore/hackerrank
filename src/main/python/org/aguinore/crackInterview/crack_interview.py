

def number_of_pairs(arr):
    stack = set()
    pairs = 0
    for num in arr:
        if num in stack:
            pairs += 1
            stack.remove(num)
        else:
            stack.add(num)
    return pairs
