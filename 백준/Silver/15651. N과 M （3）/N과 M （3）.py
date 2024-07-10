n, m = map(int, input().split())
arr = [0] * m
isUsed = [0] * (n+1)

def func(cnt):
    if cnt == m:
        for i in arr:
            print(i, end= ' ')
        print()
        return

    for i in range(1, n+1):
        arr[cnt] = i
        func(cnt+1)
func(0)
