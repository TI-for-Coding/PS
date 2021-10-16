# 시간초과 오류가 나네용 ㅜㅜ

N, M = map(int, input().split(' '))

passengers = [list(map(int, input().split(' '))) for i in range (N)]

passengers_backtrcking = []

for p in passengers :

    if p[0] > p[1] :

        passengers_backtrcking.append(p)

passengers_backtrcking.sort()

start, end = passengers_backtrcking.pop(0)

for pb in (passengers_backtrcking):

    if (end <= pb[1] <= start) :
        start = pb[0]

    elif start < pb[1] :
        M = M + (start - end) * 2
        start = pb[0]
        end = pb[1]

M = M + (start - end) * 2

print(M)
