from collections import deque
import sys

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(row, col):
    area = 0
    q = deque()
    vis[row][col] = True
    q.append((row, col))
    while q:
        cur_x, cur_y = q.popleft()
        area += 1
        # print(f'({cur_x}, {cur_y}) -> ', end='')
        for dir in range(4):
            nx = cur_x + dx[dir]
            ny = cur_y + dy[dir]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if vis[nx][ny] or board[nx][ny] != 1:
                continue
            vis[nx][ny] = True
            q.append((nx, ny))

    return area



n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, sys.stdin.readline().split())))
vis = [[False] * m for _ in range(n)]

count = 0
max = 0

for row in range(n):
    for col in range(m):
        if board[row][col] == 1 and vis[row][col] == False:
            count+=1
            area = bfs(row, col)
            max = max if max > area else area
print(count)
print(max)