from collections import deque
import sys

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

N, M = 0 , 0

def bfs(board, vis, row, col):
    q = deque()
    vis[row][col] = True
    q.append((row, col))

    while q:
        cur_x, cur_y = q.popleft()
        # print(f'({cur_x}, {cur_y}) -> ', end='')
        for dir in range(4):
            nx = cur_x + dx[dir]
            ny = cur_y + dy[dir]
            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue
            if vis[nx][ny] or board[nx][ny] == 0:
                continue
            vis[nx][ny] = True
            q.append((nx, ny))


T = int(input())

for _ in range(T):
    M, N, C = map(int, sys.stdin.readline().split())
    board = [[0 for _ in range(N)] for i in range(M)]
    vis = [[False for _ in range(N)] for i in range(M)]
    count = 0
    for _ in range(C):
        row, col = map(int, sys.stdin.readline().split())
        board[row][col] = 1

    for i in range(M):
        for j in range(N):
            if board[i][j] != 0 and not vis[i][j]:
                count += 1
                bfs(board, vis, i, j)

    print(count)
