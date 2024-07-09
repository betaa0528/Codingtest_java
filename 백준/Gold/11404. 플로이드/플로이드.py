import sys
city = int(input())
bus = int(input())
graph = [[float("inf")] * (city + 1) for _ in range(city + 1)]

for _ in range(bus):
    s, e, cost = map(int, sys.stdin.readline().split())
    graph[s][e] = cost if graph[s][e] == 0 else min(graph[s][e], cost)

for i in range(1, city + 1):
    graph[i][i] = 0
    for j in range(1, city + 1):
        for k in range(1, city + 1):
            graph[j][k] = min(graph[j][i] + graph[i][k], graph[j][k])

for i in range(1, city + 1):
    for j in range(1, city + 1):
        if graph[i][j] == float("inf"):
            graph[i][j] = 0
        print(graph[i][j], end=' ')
    print()
