from collections import deque
dq = deque()
set = set()
n,m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
isUsed = [0] * n
arr = [0] * m

def func(cnt):
    if cnt == m:
        s = ''
        for i in arr:
            s += str(i) + '/'
        if not dq or s not in set:
            a = arr.copy()
            set.add(s)
            dq.append(a)
        return

    for i in range(0, n):
        if not isUsed[i]:
            isUsed[i] = 1
            arr[cnt] = nums[i]
            func(cnt+1)
            isUsed[i] = 0

func(0)
for a in dq:
    while a:
        print(a.pop(0), end=' ')
    print()

