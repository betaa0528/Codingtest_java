
n = int(input())
arr = list(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))
arr.sort()


def binSearch(start, end, mid, target):
    global answer
    if start > end:
        answer = 0
        return

    if arr[mid] == target:
        answer = 1
        return
    elif arr[mid] > target:
        binSearch(start, mid - 1, (start + mid) // 2, target)
    else:
        binSearch(mid + 1, end, (mid + end) // 2 + 1, target)

answer = 0
for t in targets:
    binSearch(0, n-1, n // 2, t)
    print(answer)