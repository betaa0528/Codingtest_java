n, k = map(int, input().split())
arr = list(map(int, input().split()))
start, end = 0, 0
visit = [0] * (max(arr)+1)
answer = 0
while start <= end < n:
    if visit[arr[end]] < k:
        visit[arr[end]] += 1
        end += 1
    else:
        answer = max(answer, end - start)
        while visit[arr[end]] >= k:
            visit[arr[start]] -= 1
            start += 1

answer = max(answer, end - start)
print(answer)