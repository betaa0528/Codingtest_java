answer =0
cnt = 1
while True:
    L, P, V = map(int, input().split())
    if L == 0 and P == 0 and V == 0:
        break
    print("Case {0}: {1}".format(cnt, (V // P) * L +  min(V % P, L)))
    cnt += 1