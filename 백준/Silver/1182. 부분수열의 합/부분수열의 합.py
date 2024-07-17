n, s = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0


def backtrack(cnt, goal, start, sumArr):
    global answer
    if cnt == goal:
        if sum(sumArr) == s:
            answer += 1

    for i in range(start, n):
        sumArr.append(arr[i])
        backtrack(cnt + 1, goal, i + 1, sumArr)
        sumArr.pop()


for i in range(n):
    backtrack(0, i+1, 0, [])
print(answer)