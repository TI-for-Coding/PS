# 작성일 : 2021.10.04
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>힙(Heap)>디스크 컨트롤러]
# 메모 : Heap 자료구조를 사용하지 않은 풀이

def solution(jobs):

    sum_job_time = 0                    # 전체 작업의 작업시간 합산을 위한 변수
    job_cnt = len(jobs)                 # 전체 작업의 개수를 저장하기 위한 변수
    jobs.sort(key = lambda x : x[0])    # 초기 작업시작점을 찾기 위해, 요청시간 기준 Sort
    time = jobs[0][0]                   # 초기 작업시작접은 최초 작업의 요청시간

    while jobs != []:   # 작업 완료하면 Pop하기 때문에, 작업이 남아있기 전까지 반복 수행

        idx = 0             # jobs 배열에서의 인덱스를 저장
        availble_jobs = []  # 수행가능한 작업 리스트를 선언

        for starttime, jobtime in jobs:

            if starttime <= time:

                availble_jobs.append([starttime, jobtime, idx])

            idx = idx + 1

        availble_jobs.sort(key = lambda x : x[1])

        if len(availble_jobs) > 0:   # CASE 1 :: 힙 정렬에 작업이 존재하는 경우 -> 작업 수행

            starttime, jobtime, idx = availble_jobs[0]

            time = time + jobtime   # 현재 작업을 수행 (현 시간 + 작업시간)

            sum_job_time = sum_job_time + time - starttime # 전체 작업시간은

            jobs.pop(idx)   # 작업 완료되면 기존 작업 배열에서 pop

        else:   # CASE 2 :: 힙 정렬에 작업이 존재하지 않는 경우 -> 현 시점에서 작업 수행 불가

            time = time + 1 # 시간 1 경

    answer = sum_job_time // job_cnt    # 최종 답안을 answer 변수에 저장

    return answer
