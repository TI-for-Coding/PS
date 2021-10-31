# 작성일 : 2021.10.30
# 언어 : Python
# 출처 : ACMICPC(백준) [1260번 : DFS와 BFS]
# 메모 : 양방향 그래프의 DFS, BFS 탐색 결과 출력

from collections import deque

def dfs(graph, root):       # 깊이우선탐색 (Depth First Search, DFS)

    visited = []
    stack = [root]          # stack 자료구조

    while stack:

        n = stack.pop()

        if n not in visited:

            visited.append(n)

            if n in graph:

                temp = list(set(graph[n]) - set(visited))
                temp.sort(reverse = True)
                stack = stack + temp

        #print(visited)

    return " ".join(str(i) for i in visited)


def bfs(graph, root):       # 너비우선탐색 (Breadth First Search, BFS)

    visited = []
    queue = deque([root])   # queue 자료구조

    while queue:

        n = queue.popleft()

        if n not in visited:

            visited.append(n)

            if n in graph:

                temp = list(set(graph[n]) - set(visited))
                temp.sort()
                queue = queue + deque(temp)

        #print(visited)

    return " ".join(str(i) for i in visited)

graph = {}
input_val = input().split(' ')
N, M, V = [int(i) for i in input_val]

for m in range (M) :          # 양방향 그래프 구성

    edge_info = input().split(' ')
    n1, n2 = [int(j) for j in edge_info]

    if n1 not in graph :
        graph[n1] = [n2]
    elif n2 not in graph[n1] :
        graph[n1].append(n2)

    if n2 not in graph :
        graph[n2] = [n1]
    elif n1 not in graph[n2] :
        graph[n2].append(n1)

#print(graph)
print(dfs(graph, V))
print(bfs(graph, V))
