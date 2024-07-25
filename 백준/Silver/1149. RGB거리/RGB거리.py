import sys

read = sys.stdin.readline

n = int(read().strip())
r = 0
g = 1
b = 2
rgb = [list(map(int, read().split())) for _ in range(n)]

dp = [[0] * 3 for _ in range(n)]

dp[0][r] = rgb[0][r]
dp[0][g] = rgb[0][g]
dp[0][b] = rgb[0][b]

for i in range(1, n):
    dp[i][r] = min(dp[i-1][g] , dp[i-1][b]) + rgb[i][r]
    dp[i][g] = min(dp[i-1][r] , dp[i-1][b]) + rgb[i][g]
    dp[i][b] = min(dp[i-1][r] , dp[i-1][g]) + rgb[i][b]

print(min(dp[n-1][r], min(dp[n-1][g], dp[n-1][b])))