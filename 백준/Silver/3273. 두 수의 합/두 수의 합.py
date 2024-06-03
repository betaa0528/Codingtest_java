lenn = int(input())
nums = list(map(int, input().split()))
arr = [0 for i in range(2000001)]
target = int(input())
count = 0

for num in nums:
    if target - num > 0 and arr[target - num] == 1:
        count += 1
    arr[num] = 1

print(count)