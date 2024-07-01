N, K = map(int, input().split())
coin = [int(input()) for _ in range(N)]
coin.reverse()
answer = 0
for c in coin:
    if c > K:
        continue
    if K == 0:
        break
    answer += K // c
    K -= K // c * c
print(answer)