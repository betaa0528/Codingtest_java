import sys
wine = sys.stdin.readline

n = int(input())
wines = [0]
dp = [0] * (n+1)
for _ in range(n):
    wines.append(int(wine()))

dp[1] = wines[1]
if n != 1 :
    dp[2] = wines[1] + wines[2]

    for i in range(3, len(wines)):
        dp[i] = max(max(dp[i-2], dp[i-3] + wines[i-1]) + wines[i], dp[i-1])

print(dp[-1])
