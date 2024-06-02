a = [i for i in range(0,21)]
for j in range(10):
    start, end = map(int, input().split())
    aCopy = a[start:end+1].copy()
    aCopy.reverse()
    for c in aCopy:
        a[start] = c
        start += 1
a.remove(0)
[print(num, end=' ') for num in a]