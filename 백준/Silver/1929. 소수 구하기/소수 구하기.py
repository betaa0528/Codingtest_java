a,b = map(int, input().split())

era = [True] * (b+1)

n = int(b**0.5)
era[1] = False
for i in range(2,n+1):
    if era[i] == True :
        for j in range(i+i,b+1,i):
            era[j] = False

for k in range(a,b+1):
    if era[k] == True:
        print(k)