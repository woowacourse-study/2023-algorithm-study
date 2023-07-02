input = __import__('sys').stdin.readline
from collections import deque
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

n = int(input())
arr = [[*map(int, input().split())] for _ in range(n)]

for i in range(n):
    for j in range(n):
        if arr[i][j] == 9:
            sx, sy = i, j

size = 2
eat_count = 0
flag = True
time = 0
while flag:
    q = deque([[sx, sy]])
    visited = [[-1] * n for _ in range(n)]
    visited[sx][sy] = 0
    arr[sx][sy] = 0
    can_eat = []

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1 and size >= arr[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])
                if 0 < arr[nx][ny] < size:
                    can_eat.append([visited[nx][ny], nx, ny])

    if len(can_eat) == 0: break

    dist, cx, cy = sorted(can_eat)[0]
    time += dist
    sx, sy = cx, cy
    eat_count += 1
    if eat_count == size:
        eat_count = 0
        size += 1

print(time)