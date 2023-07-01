input = __import__('sys').stdin.readline

n, m = map(int, input().split())
arr = [[*input()] for _ in range(n)]

length = min(n, m)
for i in range(length, 0, -1):
    for x in range(0, n - i):
        for y in range(0, m - i):
            if arr[x][y] == arr[x+i][y] and arr[x][y] == arr[x][y+i] and arr[x][y] == arr[x+i][y+i]:
                print((i+1) * (i+1))
                exit()
print(1)