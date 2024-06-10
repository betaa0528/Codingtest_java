import sys
import heapq
# input = sys.stdin.readline
N = int(sys.stdin.readline().rstrip())
towers = list(map(int, sys.stdin.readline().split()))
stack = []
answer = [0] * N
for i in range(N-1, -1, -1):
    if len(stack) == 0:
        stack.append(i)
    elif towers[stack[-1]] > towers[i] :
        stack.append(i)
    else:
        while len(stack) > 0 and towers[stack[-1]] <= towers[i] :
            answer[stack[-1]] = i+1
            stack.pop()
        stack.append(i)

[print(i, end = ' ') for i in answer]