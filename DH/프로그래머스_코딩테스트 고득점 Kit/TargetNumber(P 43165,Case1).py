# 작성일 : 2021.10.31
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>DFS/BFS>타겟 넘버]
# 메모 : 완전 탐색을 통해 (추후 DFS/BFS 방법론을 적용해볼 예정)
#       1. 주어지는 값 n에 대해 (여기서는 1으로 고정)
#       2. 조합이 가능한 모든 case를 구성하여, tree에 저장
#       3. tree 내에서 조회하고자 하는 targer을 count

def solution(numbers, target):
    answer = 0
    tree = [0]

    for n in numbers:

        #print("n", n)
        sub_tree = []

        for t in tree:
            sub_tree.append(t + n)
            sub_tree.append(t - n)

            #print("t", t)
            #print("sub_tree", sub_tree)

        tree = sub_tree

    return tree.count(target)
