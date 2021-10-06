def solution(citations):
    citations.sort()
    citations.reverse()
    answer = len(citations)
    while answer > 0 :
        if citations[(answer - 1)] >= answer :
            break
        else :
            answer = answer - 1
            continue
    return answer
