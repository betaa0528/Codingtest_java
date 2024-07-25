n, m = map(int, input().split())
trees = list(map(int, input().split()))
trees.sort(reverse=True)
def binarySearch(low, high, target):
    global answer
    while low <= high:
        center = (low + high) // 2
        result = sumTree(center)
        if result == target:
            answer = center
            return
        elif result > target:
            answer = center
            low = center + 1
        elif result < target:
            high = center - 1


def sumTree(center):
    result = 0
    for tree in trees:
        if tree <= center:
            break
        result += tree - center
    return result


answer = 0
binarySearch(0, trees[0], m)
print(answer)
