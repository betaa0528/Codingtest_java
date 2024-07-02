time = int(input())
btn = [300, 60, 10]
answer = ''
for b in btn:
    answer += (str) (time // b)
    answer += ' '
    time = time % b
print(answer) if time == 0 else print(-1)