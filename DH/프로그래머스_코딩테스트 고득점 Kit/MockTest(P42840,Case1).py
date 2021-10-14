# 작성일 : 2021.10.14
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>완전탐색>모의고사]
# 메모 : 문제별 인덱스를 답안의 반복 주기로 나누어, 정답과 비교

def solution(answers):
    score = [[0, 1], [0, 2], [0, 3]]
    answer = []

    student1 = [1, 2, 3, 4, 5]
    student2 = [2, 1, 2, 3, 2, 4, 2, 5]
    student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    idx = 0
    for a in answers:                     # 정답과 각 학생의 답안을 비교
      
        if a == student1[idx % 5]:
            score[0][0] = score[0][0] + 1
        if a == student2[idx % 8]:
            score[1][0] = score[1][0] + 1
        if a == student3[idx % 10]:
            score[2][0] = score[2][0] + 1

        idx = idx + 1

    max = -1
    for s in score :                      # 고득점 답안자를 answer 리스트에 저장
        if s[0] > max :
            max = s[0]
            answer.clear()
        if s[0] == max :
            answer.append(s[1])

    return answer
