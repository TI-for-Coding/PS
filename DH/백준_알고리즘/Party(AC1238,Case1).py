

import heapq

N, M, X = [int(i) for i in input().split(' ')]
INF = 1
student = [0 for i in range(N + 1)]

route_graph = [[] for i in range(N + 1)]

for i in range(M):
    start, end, time = [int(j) for j in input().split(' ')]
    route_graph[start].append([end, time])
    INF = INF + time

distance_graph = [[INF for i in range(N + 1)] for j in range(N + 1)]

for i in range(1, N + 1):

    distance_graph[i][i] = 0
    queue = []
    heapq.heappush(queue, [0, i])

    while queue:

        cum_time, end = heapq.heappop(queue)

        if distance_graph[i][end] < cum_time:
            continue

        for target in route_graph[end]:

            tgt_end, tgt_time = target

            if distance_graph[i][tgt_end] >= cum_time + tgt_time:
                distance_graph[i][tgt_end] = cum_time + tgt_time

                heapq.heappush(queue, [cum_time + tgt_time, tgt_end])

result = 0
for i in range(1, N + 1):
    if result < distance_graph[i][X] + distance_graph[X][i]:
        result = distance_graph[i][X] + distance_graph[X][i]
print(result)
