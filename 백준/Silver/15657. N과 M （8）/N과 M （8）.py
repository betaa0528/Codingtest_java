n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
arr = [0] * m
def func(cnt, s):
    if cnt == m:
        [print(i, end=' ') for i in arr]
        print()
        return
    for i in range(s, n):
        arr[cnt] = nums[i]
        func(cnt + 1, i)
func(0, 0)
