import sys
import heapq
cinput = sys.stdin.readline
n = int(input())
times = [tuple(map(int, cinput().split())) for _ in range(n)]
times.sort()
heap = []
heapq.heappush(heap, times[0][1])

for s,e in times[1:]:
    if heap[0] <= s:
        heapq.heappop(heap)
    heapq.heappush(heap, e)

print(len(heap))