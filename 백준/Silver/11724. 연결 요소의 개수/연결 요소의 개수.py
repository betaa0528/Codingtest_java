import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
vis = [0] * (n + 1)
graph = [[] for i in range(n+1)]
cnt = 0

for _ in range(m):
    row, col = map(int, sys.stdin.readline().split())
    graph[row].append(col)
    graph[col].append(row)


for i in range(1, n+1):
    if vis[i] == 1:
        continue
    else:
        cnt +=1
        deq = deque()
        deq.append(i)
        vis[i] = 1
        while deq:
            node = deq.popleft()
            for i in graph[node]:
                if vis[i] == 1: continue
                deq.append(i)
                vis[i] = 1

print(cnt)
