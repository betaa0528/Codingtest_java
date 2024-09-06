n = int(input())
arr = list(map(int, input().split()))
dp = {}
answer = 1
for i in range(n):
    num = arr[i]
    arr.append(num)
    if num not in dp:
        dp[num] = 1

    for j in range(i):
        if arr[j] < num and dp[num] <= dp[arr[j]]:
            dp[num] = dp[arr[j]] + 1
            answer = max(answer, dp[num])
print(answer)
