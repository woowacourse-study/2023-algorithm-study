dic = {}

dic['................'] = 0
dic['****............'] = 0
dic['********........'] = 0
dic['************....'] = 0
dic['****************'] = 0
dic['................'] = 0

n, m = map(int, input().split())
input() # 빈줄
answer = []
for i in range(n): # 한층
    temp = []
    for j in range(m):
        temp.append("")
    answer.append(temp)

for i in range(n): # 한층
    for _ in range(4): # 한층에 몇집
        strs = input()
        temp = strs.split("#")
        for k in range(0, m):
            answer[i][k] += temp[k+1]
    input() # 빈줄

for ans in answer:
    for an in ans:
        dic[an] += 1

print(*list(dic.values()))