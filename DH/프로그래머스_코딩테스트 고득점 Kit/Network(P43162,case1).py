# 작성일 : 2021.10.31
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>DFS/BFS>네트워크]
# 메모 : 방문 기록 리스트 visited를 선언하고, 여기서 방문하지 않은 노드를 기점으로
#       방문 가능한 모든 노드를 조회하여 연결되어 있는 네트워크 개수 (answer) 를 1씩 추가

def solution(n, computers):

    answer = 0
    visited = [False for i in range(n)]

    for i in range(n) :

        if visited[i] == False:     # 네트워크 간 연결되어 있음을 확인하였으면, 조회하지 않음.

            dfs(computers, visited, i)  # 네트워크 연결관계 조
            answer = answer + 1

    return answer


def dfs(computers, visited, i):     # 깊이우선탐색 (DFS)

    stack = [i]                     # stack 자료구조

    while stack:

        j = stack.pop()

        print("j" , j)

        if visited[j] == False:         # 조회하였으면, 재방문 하지 않기 위해 visited[j] = True
            visited[j] = True

        for i in range(0, len(computers)):  # 해당 영역의 방문 대상을 모두 탐색.
            if computers[j][i] == 1 and visited[i] == 0:    # 연결되어 있고, 방문하지 않았다면 stack에 저장
                stack.append(i)
