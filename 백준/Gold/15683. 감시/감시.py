import sys
import copy

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

n, m = map(int, input().split())
blind = []
cctv = []
answer = 10000000
for i in range(n):
    line = list(map(int, sys.stdin.readline().split()))
    blind.append(line)
    for j in range(len(line)):
        if line[j] != 0 and line[j] != 6:
            cctv.append((i, j, line[j]))


def ooi(x, y):
    return x < 0 or x >= n or y < 0 or y >= m

def findZero(graph):
    cnt = 0
    for line in graph:
        cnt += line.count(0)
    return cnt


def upidx(x, y, vec, blindCopy):
    vec %= 4
    nx = x
    ny = y
    while True:
        nx += dx[vec]
        ny += dy[vec]
        if ooi(nx, ny) or blindCopy[nx][ny] == 6:
            break
        if blindCopy[nx][ny] == 0:
            blindCopy[nx][ny] = 9


def backtrack(cnt, blind):
    global answer
    if cnt == len(cctv):
        answer = min(answer, findZero(blind))
        return

    cur_x, cur_y, type = cctv[cnt]
    directions = []

    if type == 1:
        directions = [[0], [1], [2], [3]]
    elif type == 2:
        directions = [[0, 2], [1, 3]]
    elif type == 3:
        directions = [[0, 1], [1, 2], [2, 3], [3, 0]]
    elif type == 4:
        directions = [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]]
    elif type == 5:
        directions = [[0, 1, 2, 3]]

    for direction in directions:
        blindCopy = copy.deepcopy(blind)
        for d in direction:
            upidx(cur_x, cur_y, d, blindCopy)
        backtrack(cnt + 1, blindCopy)

backtrack(0, blind)
print(answer)