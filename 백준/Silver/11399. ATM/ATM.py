import sys

tc = int(input())
people = list(map(int, sys.stdin.readline().split()))

people.sort()
answer = [people[0]]
for i in range(1, len(people)):
    answer.append(answer[i-1] + people[i])
print(sum(answer))