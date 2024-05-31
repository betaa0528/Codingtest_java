a,b,c= map(int,input().split())
arr = [a,b,c]
answer = 0
if(a == b and b == c):
    answer = 10000+a*1000
elif(a!=b and b!=c and a!=c):
    answer = max(arr)*100
else:
    if(b == c): answer = b * 100
    else: answer = a * 100
    answer += 1000
print(answer)
