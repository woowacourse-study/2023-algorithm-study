n, m = map(int, input().split())
arr = []

for i in range(n):
    arr.append(input())

answer = 1
for i in range(n):
    for j in range(m):
        for k in range(j + 1, m):
            if i + k - j < n and k - j < m and arr[i][j] == arr[i][k] and arr[i][j] == arr[i+k-j][j] and arr[i+k-j][j] == arr[i+k-j][k]:
                answer = max(answer, ((k-j+1) ** 2))

print(answer)
