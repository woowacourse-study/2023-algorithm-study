import sys

nums = sorted([int(sys.stdin.readline())
              for _ in range(int(sys.stdin.readline()))])

print('\n'.join(list(map(str, nums))))
