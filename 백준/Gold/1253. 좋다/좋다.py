def twoPoint(nums, n):
    global count
    for i in range(0, len(nums)):
        l, r = 0, len(nums) - 1
        while l < r:
            sum = nums[l] + nums[r]
            if sum == nums[i]:
                if i == r:
                    r -= 1
                elif i == l:
                    l += 1
                else:
                    count += 1
                    break
            elif sum < nums[i]:
                l += 1
            else:
                r -= 1

n = int(input())
nums = list(map(int, input().split()))
nums.sort()
count = 0
twoPoint(nums, n)
print(count)
