import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()
count = 0
start = 0
end = 0
sum = nums[start] + nums[end]
for i in range(0, N):
    target = nums[i]
    start = 0
    end = N - 1
    while start < end :
        sum = nums[start] + nums[end]
        if target == sum:
            if i == start:
                start += 1
            elif i == end:
                end -= 1
            else:
                count += 1
                break
        elif sum > target :
            end -= 1
        else :
            start +=1
print(count)