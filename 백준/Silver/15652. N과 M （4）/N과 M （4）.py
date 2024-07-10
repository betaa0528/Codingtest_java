n, m = map(int, input().split())
arr = [0] * m
isUsed = [0] * (n + 1)
def func(cnt, s):
    if cnt == m:
        [print(i, end=' ') for i in arr]
        print()
        return
    for i in range(s, n+1):
        arr[cnt] = i
        func(cnt + 1, i)
func(0, 1)