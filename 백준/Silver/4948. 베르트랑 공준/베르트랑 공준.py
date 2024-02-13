while True:

    a = int(input())
    if a == 0:
        break
    sieve = [True] * (2*a+1)

    n = int((2*a+1)**0.5)

    for i in range (2,n+1):
        if sieve[i] == True:
            for j in range(i+i,2*a+1,i):
                sieve[j] = False

    print(sieve[a+1:].count(True))
