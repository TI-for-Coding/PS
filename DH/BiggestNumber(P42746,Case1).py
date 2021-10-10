def solution(numbers):
    # 아래를 기준으로 정렬하면 최고값이 나옴
    # 1. 앞자리가 높을 수록 앞에
    # 2. 앞자리가 같다면, 4,3,2,1자리수의 최소공배수인 12자리수로 치환하여 값이 높을수록 앞에
    # 3. 12자리로 치환하여 값이 같다면, 원래 자리수가 작을수록 앞에
    # => 해당 수를 조합하면 3단계의 정렬을 수행하지 않고도 최대값 출력 가능

    fn_numbers = []

    for n in numbers:
        fn_numbers.append([n, int(str(n)[0] + str(twlv_digit_conv(n)) + str(4 - number_digit_print(n)))])

    fn_numbers.sort(key=lambda x: x[1], reverse=True)

    answer = ""
    for fn in fn_numbers:
        answer = answer + str(fn[0])

    if answer[0] == "0" :
        answer = "0"

    return answer


def twlv_digit_conv(number):
    answer = int(word_paste(str(number), 12 / number_digit_print(number)))
    return answer


def number_digit_print(number):
    answer = len(str(number))
    return answer


def word_paste(word, cnt):
    i = 0
    answer = ""
    while i < cnt:
        answer = answer + word
        i = i + 1
    return answer
