target = int(input())
INF = 1000000
dp = [INF] * (target + 1)
dp[0] = dp[1] = 0
answer = [target]
for i in range(2, target + 1):
    if i % 6 == 0:
        dp[i] = min(dp[i // 3], dp[i // 2]) + 1
    elif i % 3 == 0:
        dp[i] = min(dp[i // 3], dp[i - 1]) + 1
    elif i % 2 == 0:
        dp[i] = min(dp[i // 2], dp[i - 1]) + 1
    else:
        dp[i] = dp[i - 1] + 1
print(dp[target])
print(target, end=' ')
i = target
while i > 1:
    if i % 6 == 0:
        if dp[i // 3] < dp[i // 2]:
            i //= 3
            print(i, end=' ')
        else:
            i //= 2
            print(i, end=' ')
    elif i % 2 == 0:
        if dp[i // 2] < dp[i - 1]:
            i //= 2
            print(i, end=' ')
        else:
            i -= 1
            print(i, end=' ')
    elif i % 3 == 0:
        if dp[i // 3] < dp[i - 1]:
            i //= 3
            print(i, end=' ')
        else:
            i -= 1
            print(i, end=' ')
    else:
        i -= 1
        print(i, end=' ')
