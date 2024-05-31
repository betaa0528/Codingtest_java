r = 'EABCD'
for i in range(3):
    a,b,c,d= input().split()
    print(r[(a+b+c+d).count('0')])
