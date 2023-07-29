import sys

top = -1
stack = [0] * 100_000
for _ in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())
    if n == 0 and top != -1:
        top -= 1
    else:
        top += 1
        stack[top] = n

if top == -1:
    print(0)
else:
    print(sum(stack[:top+1]))
