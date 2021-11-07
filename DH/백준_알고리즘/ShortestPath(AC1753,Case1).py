# 작성일 : 2021.11.07
# 언어 : Python
# 출처 : ACMICPC(백준) [1753번 : 최단경로]
# 메모 : 시작점 K에서부터 주어진 경로정보를 통해 최단경로를 구하는 다익스트라 알고리즘으로 구현하였음.

import heapq

V, E = map(int, input().split(' '))   # 정점 V, 간선 E, 시작점 K
K = int(input())
INF = 300000 * 10   # 최대값은 간선의 최대 개수 300000 * 간선의 가중치 10

distance_graph = [[] * (V + 1) for i in range(V + 1)]

for i in range(E) :

    start, end, distance = map(int, input().split(' '))   # 각 간선의 정보 입력
    distance_graph[start].append((end, distance))         # 경로 그래프에 시작점을 key로 하여 도착지 및 가중치 저장

from_K_distance_graph = [INF for i in range(V + 1)]       # K로부터 최단경로 정보 입력
from_K_distance_graph[K] = 0                              # K -> K 최단경로는  0

queue = []
heapq.heappush(queue, [0, K])                             # 시작점을 Queue에 저장

while queue :

    cum_distance, start = heapq.heappop(queue)

    if from_K_distance_graph[start] < cum_distance :      # 현재 최단경로에 비해 가중치가 더 큰 경우에는 조회할 필요 없음 

        continue

    for target in distance_graph[start] :                 # 해당 경로에서의 접근 가능한 경로를 모두 조회

        end, distance = target
        cost = cum_distance + distance

        if from_K_distance_graph[end] > cost :            # 기존 최단경로에 비해 조회하는 경로의 비용이 더욱 작을 경우,

            from_K_distance_graph[end] = cost
            heapq.heappush(queue, (cost, end))

for i in range(1, V + 1) :                                # 정점 K에서 각 노드로 가는 최단경로 출력

    if from_K_distance_graph[i] == INF :
        print("INF")
    else :
        print(from_K_distance_graph[i])
