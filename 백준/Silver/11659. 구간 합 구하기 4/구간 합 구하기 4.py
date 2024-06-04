a,b = map(int, input().split())
arr = list(map(int, input().split()))
sum = [0]
for i in range(1, a+1):
     sum.append(sum[i-1] + arr[i-1])

for i in range(b):
    s, e = map(int, input().split())
    print(sum[e] - sum[s-1])


