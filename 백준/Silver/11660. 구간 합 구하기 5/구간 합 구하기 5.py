import sys
input = sys.stdin.readline

size, times = map(int, input().split())
arr = [list(map(int, input().split())) for i in range(size)]
sum = [[0 for j in range(size+1)] for i in range(size+1)]
for i in range(1, size+1):
    for j in range(1, size+1):
        sum[i][j] = sum[i-1][j] + sum[i][j-1] + arr[i-1][j-1] - sum[i-1][j-1]

for i in range(times):
    x1,y1,x2,y2 = map(int, input().split())
    print(sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1])
    