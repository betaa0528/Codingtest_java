a,b,c = [int(input())for i in range(3)]
result = str(a*b*c)
[print(result.count(str(i))) for i in range(0,10)]