import sys
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def bfs():
    maxVal = 0
    while queue:
        row, col = queue.popleft()
        for i in range(4):
            if row + dx[i] < 0 or col + dy[i] < 0 or row + dx[i] >= m or col + dy[i] >= n:
                continue
            if graph[row + dx[i]][col + dy[i]] != 0:
                continue
            queue.append((row + dx[i], col + dy[i]))
            graph[row + dx[i]][col + dy[i]] = graph[row][col] + 1
            maxVal = max(maxVal, graph[row][col] + 1)
    return maxVal
n, m = map(int, input().split())
graph = []
queue = deque()

minusCnt = 0

for i in range(m):
    line = list(map(int, sys.stdin.readline().split()))
    minusCnt += line.count(-1)
    for idx, val in enumerate(line):
        if val == 1: queue.append((i, idx))
    graph.append(line)

answer = -1

if queue:
    if len(queue) + minusCnt == n * m:
        answer = 0

if answer == -1:
    answer = bfs() - 1
    for tomato in graph:
        if 0 in tomato:
            answer = -1
print(answer)