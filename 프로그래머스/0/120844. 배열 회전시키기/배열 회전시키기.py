def solution(numbers, direction):
    if direction == 'right':
        answer = [numbers[-1]]
        answer.extend(numbers[0:-1])
    else : 
        answer = numbers[1:]
        tmp = [numbers[0]]
        answer.extend(tmp)
    return answer