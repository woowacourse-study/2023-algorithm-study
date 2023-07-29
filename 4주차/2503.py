from itertools import permutations

nums = list(permutations([i for i in range(1, 10)], 3))


def get_count(n: int, num: tuple):
    s = b = 0
    for i, k in enumerate(str(n)):
        k = int(k)
        if k == num[i]:
            s += 1
        elif k in num:
            b += 1
    return s, b


for _ in range(int(input())):
    n, s, b = map(int, input().split())
    gap = 0

    for i in range(len(nums)):
        i -= gap

        s_count, b_count = get_count(n, nums[i])

        if s_count != s or b_count != b:
            nums.remove(nums[i])
            gap += 1

print(len(nums))
