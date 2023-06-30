n = int(input())
nums = sorted(list(map(int, input().split())))
x = int(input())

head = 0
tail = n-1
result = 0
while head < tail:
    sum = nums[head] + nums[tail]
    if sum == x:
        head += 1
        tail -= 1
        result += 1
    elif sum < x:
        head += 1
    else:
        tail -= 1
print(result)
