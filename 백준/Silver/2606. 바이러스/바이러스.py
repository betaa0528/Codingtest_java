from collections import deque
import sys
def bfs(graph, start, visit, count):
    queue = deque()
    queue.append(start)
    visit[start] = True
    while queue:
        node = queue.popleft()
        # print(node, end=' ')
        for i in graph[node]:
            if not visit[i]:
                queue.append(i)
                count += 1
                visit[i] = True

    return count
computer = int(input())
vertex = int(input())
graph = []
visit = [False] * (computer + 1)
for _ in range(computer + 1):
    graph.append([])
for i in range(vertex):
    com1 , com2 = map(int, sys.stdin.readline().split())
    if com2 not in graph[com1]:
        graph[com1].append(com2)
    if com1 not in graph[com2]:
        graph[com2].append(com1)

count = bfs(graph, 1, visit, 0)
print(count)