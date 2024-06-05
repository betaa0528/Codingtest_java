def solution(n):
    num = 1
    while True:
        if n == num**2:
            answer = 1
            break
        elif num**2 > n: 
            answer = 2
            break
        num += 1
    
    return answer