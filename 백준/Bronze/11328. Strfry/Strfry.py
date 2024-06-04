import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    word1, word2 = map(sorted, list(input().split()))
    print("Possible" if word1 == word2 else "Impossible")


