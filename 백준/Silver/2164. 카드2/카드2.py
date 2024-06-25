from collections import deque

q = deque()

num = int(input())

for i in range(1, num + 1):
    q.append(i)

while len(q) > 1:
    q.popleft()
    q.append(q.popleft())
print(q.pop())
