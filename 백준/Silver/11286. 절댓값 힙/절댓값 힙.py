import sys
import heapq

arr = []
q = heapq
N = int(sys.stdin.readline())
for _ in range(N):
    num = int(sys.stdin.readline())
    if num != 0:
        q.heappush(arr, (abs(num), num))
    elif num == 0:
        if len(arr) == 0:
            print(0)
            continue
        print(q.heappop(arr)[1])
