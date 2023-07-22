N, M = map(int, input().split())
windows = [input() for _ in range(N*5+1)]


def get_status(r: int, c: int) -> int:
    for i in range(5):
        if windows[r+i][c] != '*':
            return i


result = [0] * 5
for r in range(N):
    for c in range(M):
        status = get_status(r*5+1, c*5+1)
        result[status] += 1

print(' '.join(map(str, result)))
