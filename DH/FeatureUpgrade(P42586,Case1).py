def solution(progresses, speeds):
    answer = []

    while len(progresses) != 0:

        print(progresses)
        print(speeds)

        idx = 0
        while idx < len(progresses):
            progresses[idx] = progresses[idx] + speeds[idx]
            idx = idx + 1

        idx = 0
        while len(progresses) != 0:
            if progresses[0] >= 100:
                progresses.pop(0)
                speeds.pop(0)
                idx = idx + 1
            else :
                break

        if idx != 0 :
            answer.append(idx)

    return answer
