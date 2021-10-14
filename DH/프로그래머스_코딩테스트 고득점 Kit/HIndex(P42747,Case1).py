# 작성일 : 2021.10.06
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>정렬>H-Index]
# 메모 : 파이썬의 리스트 sort 및 reverse 기능을 활용하여 해결했습니다 
#       (더 좋은 기능이 있을법 한데...자바로 풀며 고민해보겠읍니당)

def solution(citations):
    citations.sort()
    citations.reverse()         # 최대 정렬
    answer = len(citations)
    while answer > 0 :
        if citations[(answer - 1)] >= answer :  # H-Index 찾음
            break
        else :
            answer = answer - 1             
            continue
    return answer
