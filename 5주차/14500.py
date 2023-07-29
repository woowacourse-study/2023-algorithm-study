import sys


N, M = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

max_val = 0
visited = [[False] * M for _ in range(N)]
moves = [(0, 1), (0, -1), (1, 0), (-1, 0)]


def get_next(r, c, i):
    return r + moves[i][0], c + moves[i][1]


def is_valid(r, c):
    return 0 <= r and r < N and 0 <= c and c < M and not visited[r][c]


def dfs(i, j, val, cnt):
    global max_val

    if cnt == 4:
        max_val = max(max_val, val)
        return

    for k in range(4):
        r, c = get_next(i, j, k)

        if is_valid(r, c):
            visited[r][c] = True
            dfs(r, c, val + board[r][c], cnt+1)
            visited[r][c] = False


def fxxk(i, j):
    global max_val

    for k in range(4):
        val = board[i][j]

        for l in range(3):
            move = (k+l) % 4
            r, c = get_next(i, j, move)

            if not is_valid(r, c):
                val = -1
                break
            val += board[r][c]

        max_val = max(max_val, val)


for i in range(N):
    for j in range(M):
        visited[i][j] = True
        fxxk(i, j)
        dfs(i, j, board[i][j], 1)
        visited[i][j] = False

print(max_val)
