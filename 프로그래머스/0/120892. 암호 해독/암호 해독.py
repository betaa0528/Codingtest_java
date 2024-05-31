def solution(cipher, code):
    cipher = 'a' + cipher
    answer = ''
    for i in range(1, len(cipher)):
        if(i % code == 0): answer += cipher[i]
    return answer