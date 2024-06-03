num = input()
max = 0
arr = [0 for i in range(10)]
for i in num:
    arr[int(i)] += 1
for j in range(10):
    if j != 6 and j != 9:
        if arr[j] > max:
            max = arr[j]
six = (arr[6] + arr[9]) // 2 + 1 if (arr[6] + arr[9])%2 != 0 else (arr[6] + arr[9]) // 2
max = max if max > six else six
print(max)