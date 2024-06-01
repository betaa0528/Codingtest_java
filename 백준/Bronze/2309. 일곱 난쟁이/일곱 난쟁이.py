a = [int(input()) for i in range(9)]
sum = sum(a)
for i in range(0,9):
    for j in range(i+1,9):
        if(a[i] + a[j] == sum - 100):
            r1 = a[i]
            r2 = a[j]
            a.remove(r1)
            a.remove(r2)
            break
    if(len(a) < 9) : break
a.sort()
[print(d) for d in a]