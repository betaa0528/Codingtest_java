a = []
for i in range(7):
    num = int(input())
    if(num % 2 != 0):
        a.append(num)
if(len(a) == 0):
    print(-1)
else:
    print(sum(a))
    print(min(a))