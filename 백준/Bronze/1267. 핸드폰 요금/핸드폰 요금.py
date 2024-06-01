call = int(input())
y = 0;
m = 0;
time = list(map(int, input().split()))
for i in time:
    a,b = divmod(i+1, 60)
    y += a*20 + (20 if b > 30 else 10)
    m += a*15 + (15 if b > 0 else 0)

if(y > m):
    print('M', m)
elif(m > y):
    print('Y', y)
else:
    print('Y M', y)