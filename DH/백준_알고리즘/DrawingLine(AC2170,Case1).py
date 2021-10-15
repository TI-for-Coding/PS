# 아직 미완...시간오류가 계속 발생해 ㅠㅠ

N = int(input())
lines = [list(map(int, input().split(' '))) for i in range (N)]
lines.sort()
answer = 0

min, max = lines.pop(0)

for line in (lines):

    if (max < line[0]) :
        answer = answer + max - min
        min = line[0]
        max = line[1]
    elif (max == line[0]) or (max < line[1]) :
        max = line[1]

answer = answer + max - min

print(answer)
