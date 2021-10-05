import heapq  # 힙 자료구조 사용을 위한 패키지 호출


def solution(jobs):

    sum_job_time = 0                    # 전체 작업의 작업시간 합산을 위한 변수
    job_cnt = len(jobs)                 # 전체 작업의 개수를 저장하기 위한 변수
    jobs.sort(key = lambda x : x[0])    # 초기 작업시작점을 찾기 위해, 요청시간 기준 Sort
    time = jobs[0][0]                   # 초기 작업시작접은 최초 작업의 요청시간

    while jobs != []:   # 작업 완료하면 Pop하기 때문에, 작업이 남아있기 전까지 반복 수행

         idx = 0         # jobs 배열에서의 인덱스를 저장
         heap = []       # 힙 최소 정렬을 위해 사용되는 배열

         for starttime, jobtime in jobs:

             if starttime <= time:

                 heapq.heappush(heap, (jobtime, starttime, idx)) # 작업시간 순으로 힙 최소정렬

             idx = idx + 1

         if len(heap) > 0:   # CASE 1 :: 힙 정렬에 작업이 존재하는 경우 -> 작업 수행

             jobtime, starttime, idx = heapq.heappop(heap)   # 작업시간이 제일 최소의 작업을 pop

             time = time + jobtime   # 현재 작업을 수행 (현 시간 + 작업시간)

             sum_job_time = sum_job_time + time - starttime # 전체 작업시간은

             jobs.pop(idx)   # 작업 완료되면 기존 작업 배열에서 pop

         else:   # CASE 2 :: 힙 정렬에 작업이 존재하지 않는 경우 -> 현 시점에서 작업 수행 불가

             time = time + 1 # 시간 1 경

    answer = sum_job_time // job_cnt    # 최종 답안을 answer 변수에 저장

    return answer
