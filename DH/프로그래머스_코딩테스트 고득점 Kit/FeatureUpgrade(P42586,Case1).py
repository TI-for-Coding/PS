
# 작성일 : 2021.10.07
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>스택/큐>기능개발]
# 메모 : 순차적으로 작업을 수행하며, 개별 사이클마다 세 단계로 세부 로직을 구분함
#       1) 각 기능의 개발 진도 ++
#       2) 초기 기능의 진도가 100 이상이 된디면, 후순의 기능 중 진도 100 이상인 작업을 차례로 pop
#       3) 해당 사이클에서 종료된 작업이 있다면, answer 리스트에 완료된 작업 개수를 append


def solution(progresses, speeds):
    
    answer = []

    while len(progresses) != 0:

        idx = 0
        while idx < len(progresses):                            # 1단계. 개발중인 기능에 진도 ++
            progresses[idx] = progresses[idx] + speeds[idx]
            idx = idx + 1

        idx = 0
        while len(progresses) != 0:                             # 2단계. 개발중인 기능이 있다면 반복 수행
            if progresses[0] >= 100:    # (완성된 기능의 경우 Pop)
                progresses.pop(0)
                speeds.pop(0)
                idx = idx + 1
            else :                      # (기능이 완성되지 않으면 break)
                break

        if idx != 0 :                                           # 3단계. 종료되는 작업의 개수 append
            answer.append(idx)

    return answer
