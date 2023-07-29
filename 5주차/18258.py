import sys

head = 0
tail = -1
queue = [0] * 2_000_000

for _ in range(int(sys.stdin.readline())):
    command = sys.stdin.readline().split()

    if command[0] == 'push':
        tail += 1
        queue[tail] = command[1]
    elif command[0] == 'pop':
        if head > tail:
            print(-1)
        else:
            print(queue[head])
            head += 1
    elif command[0] == 'size':
        print(tail - head + 1)
    elif command[0] == 'empty':
        print(1 if head > tail else 0)
    elif command[0] == 'front':
        if head > tail:
            print(-1)
        else:
            print(queue[head])
    elif command[0] == 'back':
        if head > tail:
            print(-1)
        else:
            print(queue[tail])
