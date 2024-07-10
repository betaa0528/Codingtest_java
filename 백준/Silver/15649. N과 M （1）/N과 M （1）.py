from collections import deque
n, m = map(int, input().split())
isUsed = [0] * (n + 1)
arr = [0] * m
def func(cnt):
    if cnt == m:
        for i in arr:
            print(i, end= ' ')
        print()
        return

    for i in range(1, n+1):
        if not isUsed[i]:
            isUsed[i] = 1
            arr[cnt] = i
            func(cnt+1)
            isUsed[i] = 0

func(0)
