import sys
input = sys.stdin.readline

answer = 0
students = [[0 , 0] for i in range(6)]
n, k = map(int, input().split())

for _ in range(n):
    gen, grade = map(int, input().split())
    students[grade-1][gen] +=1

for clazz in students:
    answer += clazz[0] // k if clazz[0] % k == 0 else clazz[0] // k + 1
    answer += clazz[1] // k if clazz[1] % k == 0 else clazz[1] // k + 1
print(answer)
