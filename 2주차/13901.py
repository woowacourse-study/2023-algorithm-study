import sys
R, C = map(int, sys.stdin.readline().split())
obsNum = int(input())
matrix = [[0]*C for _ in range(R)]
for _ in range(obsNum):
    r, c = map(int, input().split())
    matrix[r][c] = 1
sr, sc = map(int, input().split())
matrix[sr][sc] = 1
d = list(map(int, input().split()))
for i in range(4):
    d[i] -= 1
dr = [-1,1,0,0]
dc = [0,0,-1,1]
pos = 0
dirSet = set()
answer = []
while( True ):
    dirSet.add(d[pos])
    nr = sr+dr[d[pos]]
    nc = sc+dc[d[pos]]
    if nr<0 or nr>=R or nc<0 or nc>=C or matrix[nr][nc] == 1:
        pos = (pos + 1) % 4
        if d[pos] in dirSet:
            answer.append(sr)
            answer.append(sc)
            break
        else:
            continue
    else:
        dirSet = set()
        matrix[nr][nc] = 1
        sr = nr
        sc = nc
print(answer[0], answer[1])
