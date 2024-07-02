money = 1000 - int(input())
coin = [500,100,50,10,5,1]
answer = 0
for c in coin:
    answer += money // c
    money %= c
print(answer)