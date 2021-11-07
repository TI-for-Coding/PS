# 작성일 : 2021.11.06
# 언어 : Python
# 출처 : ACMICPC(백준) [1238번 : 파티]
# 메모 : N개의 마을 중 X개의 경로가 있고, X의 마을에서 파티가 열릴 때, 
# 각 마을에서 X에 가기 위한 최소 경로, 그리고 X에서 각 마을로 돌아가기 위한 최소 경로의 합이 최대인 케이스를 출력
# 단순하게, 각 마을마다 서로 다른 마을로 가는 최소 경로를 다익스트라 알고리즘으로 계산
# 최종적으로 각 마을 -> 마을 X 로 가는 경로 + 마을 X -> 각 마을로 가는 경로를 더하여 최대값 출력

import heapq

N, M, X = [int(i) for i in input().split(' ')]
INF = 1
student = [0 for i in range(N + 1)]

route_graph = [[] for i in range(N + 1)]    # 각 마을 개수만큼 경로 그래프 생성

for i in range(M):
    start, end, time = [int(j) for j in input().split(' ')] 
    route_graph[start].append([end, time])                    # 각 마을을 시작점으로 하여, 목적지 및 소요시간 append
    INF = INF + time                                          # INF는 모든 경로 길이를 더한 값 + 1

distance_list = [[INF for i in range(N + 1)] for j in range(N + 1)]    # 마을끼리의 최소 경로를 저장하기 위한 2차원 리스트 생성

for i in range(1, N + 1):                   # 마을 순서대로 다익스트라 알고리즘 계싼

    distance_list[i][i] = 0
    queue = []
    heapq.heappush(queue, [0, i])           # 각 마을의 시작점을 queue 에 저장

    while queue:

        cum_time, end = heapq.heappop(queue)

        if distance_list[i][end] < cum_time:    # 현재 최단경로에 비해 가중치가 더 큰 경우에는 조회할 필요 없음 
            continue

        for target in route_graph[end]:         # 해당 노드에 포함되어 있는 모든 경로를 조회

            tgt_end, tgt_time = target

            if distance_list[i][tgt_end] >= cum_time + tgt_time:    # 현재 노드를 거쳐 방문하는 경로가 기존 경로 길이보다 짧은 경우
                distance_list[i][tgt_end] = cum_time + tgt_time

                heapq.heappush(queue, [cum_time + tgt_time, tgt_end])   # 이동한 경로를 queue에 저장

result = 0
for i in range(1, N + 1):                                     # 각 마을 -> 마을 X 로 가는 경로 + 마을 X -> 각 마을으로 가는 시간 계산
    if result < distance_list[i][X] + distance_list[X][i]:
        result = distance_list[i][X] + distance_list[X][i]
print(result)
