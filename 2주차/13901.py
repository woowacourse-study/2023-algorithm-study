R, C = map(int, input().split())
board = [[True] * C for _ in range(R)]
for _ in range(int(input())):
    br, bc = map(int, input().split())
    board[br][bc] = False
r, c = map(int, input().split())
directions = [x-1 for x in map(int, input().split())]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

board[r][c] = False


def is_movable(r: int, c: int) -> bool:
    return -1 < r and r < R and -1 < c and c < C and board[r][c]


moved = True
direction = 0
while moved:
    moved = False
    board[r][c] = False

    for _ in range(4):
        x = c + dx[directions[direction]]
        y = r + dy[directions[direction]]
        if is_movable(y, x):
            moved = True
            r, c = y, x
            break
        direction = (direction + 1) % 4

print(r, c)
