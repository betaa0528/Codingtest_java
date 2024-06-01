a,b = map(int, input().split())
max = max(a,b)
min = min(a,b)
print(0) if a==b else print(int(max-min-1))
if (a!=b): [print(i+min, end=' ') for i in range(1, int(max-min))]