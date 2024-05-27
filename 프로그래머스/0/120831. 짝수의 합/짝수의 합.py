def solution(n):
    answer = 0
    for num in range(2, n+1) :
        if num % 2 ==0 : answer += num
    return answer