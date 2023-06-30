L = int(input())
s = list(map(int, input().split()))
s = sorted(s)
n = int(input())

answer = []
cnt = 0
if n in s:
    print(0)
else:
    start = 0
    end = 1001
    for i in range(len(s)):
        if s[i] > n:
            end = s[i]
            if i - 1 >= 0:
                start = s[i - 1]
            break
    for i in range(start + 1, end):
        for j in range(i + 1, end):
            if i <= n <= j:
                cnt += 1
    print(cnt)
    