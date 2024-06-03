word = input()
arr = [0 for i in range(26)]
for c in word:
    arr[ord(c) - 97] += 1
[print(j ,end=' ') for j in arr]