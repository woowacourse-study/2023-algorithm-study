from collections import deque
from itertools import combinations as cb
from copy import deepcopy

input = __import__('sys').stdin.readline
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

n, m = map(int, input().split())
arr = [[*map(int, input().split())] for _ in range(n)]

blank = [[x, y] for x in range(n) for y in range(m) if arr[x][y] == 0]
virus = [[x, y] for x in range(n) for y in range(m) if arr[x][y] == 2]

ans = 0
for wall in cb(blank, 3):
    replica = deepcopy(arr)
    for x, y in wall:
        replica[x][y] = 1

    q = deque([*virus])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and replica[nx][ny] == 0:
                replica[nx][ny] = 2
                q.append([nx, ny])

    val = sum(replica[x][y] == 0 for x in range(n) for y in range(m))
    ans = max(ans, val)

print(ans)