N, M = map(int, input().split())
a = list(map(int, input().split()))
s, e = 0, 0
subsum = a[0]
cnt = 0
while True:
    if subsum < M:
        e += 1
        if e >= N:
            break
        subsum += a[e]
    elif subsum == M:
        cnt += 1
        subsum -= a[s]
        s += 1
    else:
        subsum -= a[s]
        s += 1
print(cnt)
