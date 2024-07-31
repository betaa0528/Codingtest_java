import sys

def backtrack(arr, visit, cnt, start):
    if cnt == 6:
        print(*arr[:6])
        return

    for i in range(start, len(arr)):
        if visit[i] == 0 and arr[cnt-1] < lotto[i]:
            visit[i] = 1
            arr[cnt] = lotto[i]
            backtrack(arr, visit, cnt + 1, start + 1)
            visit[i] = 0
            arr[cnt] = 0


while True:
    lotto = list(map(int, sys.stdin.readline().split()))
    if len(lotto) == 1:
        break
    arr = [0 for _ in range(lotto[0] + 1)]
    visit = [0 for _ in range(lotto[0] + 1)]
    backtrack(arr, visit, 0, 1)
    print()