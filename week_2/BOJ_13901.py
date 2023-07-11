input = __import__('sys').stdin.readline
dx, dy = [0, -1, 1, 0, 0], [0, 0, 0, -1, 1]

r, c = map(int, input().split())
k = int(input())
wall = [[*map(int, input().split())] for _ in range(k)]
sr, sc = map(int, input().split())
move = [*map(int, input().split())]
idx = 0

visited = [[True] * c for _ in range(r)]
for wx, wy in wall:
    visited[wx][wy] = False
visited[sr][sc] = False

status = 4
while status:
    nx, ny = sr + dx[move[idx]], sc + dy[move[idx]]
    if 0 <= nx < r and 0 <= ny < c and visited[nx][ny]:
        sr, sc = nx, ny
        visited[sr][sc] = False
        status = 4
    else:
        idx = (idx + 1) % 4
        status -= 1
print(sr, sc)
