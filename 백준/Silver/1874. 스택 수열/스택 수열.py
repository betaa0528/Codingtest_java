import sys

N = int(sys.stdin.readline().rstrip())
nums = [int(sys.stdin.readline().rstrip()) for _ in range(N)]

cnt = 1
answer = ''
chk = True
stack = []
for i in nums:
    while cnt <= i:
        stack.append(cnt)
        answer += '+\n'
        cnt += 1

    if i == stack[-1]:
        stack.pop()
        answer += '-\n'

    if len(stack) > 0 and stack[-1] > i:
        print('NO')
        chk = False
        break

if chk:
    print(answer)
