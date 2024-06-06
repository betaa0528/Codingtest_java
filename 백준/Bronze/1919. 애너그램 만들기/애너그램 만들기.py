import sys
input = sys.stdin.readline

word1 = input()
word2 = input()

answer = 0
for i in range(26):
    num1 = word1.count(chr(i + 97))
    num2 = word2.count(chr(i + 97))
    answer += abs(num1 - num2)

print(answer)