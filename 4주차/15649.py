from itertools import permutations

N, M = map(int, input().split())

answers = list(permutations([str(i) for i in range(1, N+1)], M))

for answer in answers:
    print(' '.join(answer))
