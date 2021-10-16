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
