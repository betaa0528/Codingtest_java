import sys
inst = sys.stdin.readline
n, m = map(int, inst().split())
nums = list(map(int, inst().split()))
nums.sort()
isUsed = {}
for num in nums:
    isUsed[num] = 0
arr = [0] * m
def func(cnt):
    if cnt == m:
        [print(i, end=' ') for i in arr]
        print()
        return
    for i in nums:
        if not isUsed[i]:
            isUsed[i] = 1
            arr[cnt] = i
            func(cnt + 1)
            isUsed[i] = 0
func(0)