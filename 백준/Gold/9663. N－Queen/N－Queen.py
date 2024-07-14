n = int(input())
visit1 = [False] * n # 열에 대한 방문
visit2 = [False] * (2 * n - 1) # 우 대각선 x + y
visit3 = [False] * (2 * n - 1) # 좌 대각선 x - y + n - 1
num = 0
def backtrack(cnt):
    global num
    if cnt == n:
        num += 1
        return

    for i in range(n):
        if not visit1[i] and not visit2[cnt+i] and not visit3[cnt-i+n-1]:
            visit1[i] = True
            visit2[cnt+i] = True
            visit3[cnt-i+n-1] = True
            backtrack(cnt+1)
            visit1[i] = visit2[cnt+i] = visit3[cnt-i+n-1] = False
backtrack(0)
print(num)
