import sys

result = [0] * 10_001

for _ in range(int(sys.stdin.readline())):
    result[int(sys.stdin.readline())] += 1

for i, n in enumerate(result):
    for _ in range(n):
        print(i)
