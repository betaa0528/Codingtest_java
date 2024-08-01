def isValid(x, y):
    return 0 <= x < 5 and 0 <= y < 5


def dfs(princess, list):
    global answer, graph, isUsed
    if list.count("Y") > 3:
        return

    if len(princess) == 7:
        princess = tuple(sorted(princess))
        if princess not in isUsed:
            isUsed.add(princess)
            answer += 1
            return
        return

    for prin in princess:
        x, y = prin[0], prin[1]
        xy = [[0, 1], [-1, 0], [0, -1], [1, 0]]
        for dx, dy in xy:
            nx = x + dx
            ny = y + dy
            if isValid(nx, ny):
                if (nx, ny) not in princess:
                    dfs(princess + [(nx, ny)], list + [graph[nx][ny]])



graph = [input() for _ in range(5)]
answer = 0
isUsed = set()
for i in range(5):
    for j in range(5):
        princess = [(i,j)]
        list = [graph[i][j]]
        dfs(princess,list)
print(answer)
