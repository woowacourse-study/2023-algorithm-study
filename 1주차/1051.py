n, m = map(int, input().split())
rows = [input() for _ in range(n)]


def is_square(i, j, k):
    return rows[i][j] == rows[i][j+k] and \
        rows[i][j] == rows[i+k][j] and \
        rows[i][j] == rows[i+k][j+k]


result = 1
for i in range(n-1):
    for j in range(m-1):
        k = min(n-i-1,  m-j-1)
        for l in range(1, k+1):
            if is_square(i, j, l):
                result = max(result, (l+1)**2)
print(result)
