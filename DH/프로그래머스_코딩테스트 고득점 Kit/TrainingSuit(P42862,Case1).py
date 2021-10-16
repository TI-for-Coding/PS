# 작성일 : 2021.10.17
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>탐욕법>체육복]
# 메모 : 3개의 메소드를 선언하여 풀었음
#       solution : 입력값을 받아, 유실한 학생, 여분이 있는 학생을 정렬한 후 우선 중복값 제거 (!) <- 여기서 오답이 계속 났었음
#                  번호 상 근처에 있는 학생이 체육복을 빌려줄 수 있는 경우, pop을 통해 분실 학생을 리스트에서 제거
#       approx_contains : 특정 리스트 내에서 근사값이 존재하는 경우, 주어진 값보다 1 작으면 -1 출력,
#                         주어진 값보다 1 크면 1 출력
#       duplication_drop : 중복값 제거 (!) 를 위한 메소드로, 분실한 학생중에 여벌옷이 있는 경우에는 사전에 삭제


def solution(n, lost, reserve):

    lost.sort()
    reserve.sort()

    duplication_drop(lost, reserve)

    for r in reserve :

        check = approx_contains(lost, r)
        
        if check == -1 :
            lost.pop(lost.index(r - 1))
        elif check == 1 :
            lost.pop(lost.index(r + 1))

    return n - len(lost)


def approx_contains(list, n) :

    result = 0

    for l in list :

        if l == (n - 1) :
            result = -1
            break
        elif l == (n + 1) :
            result = 1
            break

    return result


def duplication_drop (list_a, list_b) :

    droplist_a = []
    droplist_b = []

    for i in range(len(list_a)) :

        for j in range(len(list_b)) :

            if list_a[i] == list_b[j] :

                droplist_a.append(list_a[i])
                droplist_b.append(list_b[j])

    for da in droplist_a :
        list_a.pop(list_a.index(da))

    for db in droplist_b :
        list_b.pop(list_b.index(db))
