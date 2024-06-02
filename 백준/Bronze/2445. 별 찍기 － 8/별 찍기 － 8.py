num = int(input())
for i in range(1 , num * 2 ):
    if(i > num) : i = num - i % num
    print('*'*i + ' '*(num-i)*2 + '*'*i)