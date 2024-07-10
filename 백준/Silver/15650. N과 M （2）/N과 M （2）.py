n, m = map(int, input().split())
arr = [0] * m
isUsed = [0] * (n + 1)

def func(cnt):
    if cnt == m:
        for i in arr:
            print(i, end=' ')
        print()
        return

    for i in range(1, n + 1):
        if not isUsed[i]:
            if (cnt > 0 and i > arr[cnt-1]) or cnt == 0:
                isUsed[i] = 1
                arr[cnt] = i
                func(cnt+1)
                isUsed[i] = 0
func(0)