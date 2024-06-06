import sys

input = sys.stdin.readline


for _ in range(int(input())):
    arr = []
    td = input().strip()

    for t in td:
        if not len(arr):
            arr.append(t)
            continue

        if t == ')' and arr[-1] == '(':
            arr.pop()
        else:
            arr.append(t)
    print('YES' if not len(arr) else 'NO')

