
# 작성일 : 2021.10.10
# 언어 : Python
# 출처 : 프로그래머스 [코딩테스트 연습>정렬>가장 큰 수]
# 메모 : 아래를 기준으로 정렬하면 최고값이 나옴
#       1. 앞자리가 높을 수록 앞에
#       2. 앞자리가 같다면, 4,3,2,1자리수의 최소공배수인 12자리수로 치환하여 값이 높을수록 앞에
#       3. 12자리로 치환하여 값이 같다면, 원래 자리수가 작을수록 앞에
#       => 해당 수를 조합하면 3단계의 정렬을 수행하지 않고도 최대값 출력 가능

def solution(numbers):

    fn_numbers = []

    for n in numbers:
        fn_numbers.append([n, int(str(n)[0] + str(twlv_digit_conv(n)) + str(4 - number_digit_print(n)))])   # = 기존 값, 정렬 기준 값 (메모참조)

    fn_numbers.sort(key=lambda x: x[1], reverse=True)   # 최대값을 찾기 위한 정렬

    answer = ""
    for fn in fn_numbers:
        answer = answer + str(fn[0])    # string형 결과 출력을 위해 결과값 생성

    if answer[0] == "0" :               # 반례에 대한 Problem Solving
        answer = "0"

    return answer

def twlv_digit_conv(number):            # 주어진 값에 대해 12자리 수로 치환하는 메소드
    answer = int(word_paste(str(number), 12 / number_digit_print(number)))
    return answer

def number_digit_print(number): # 자리수를 계산하는 메소드
    answer = len(str(number))
    return answer

def word_paste(word, cnt):      # 문자를 반복하여 붙여넣는 메소드
    i = 0
    answer = ""
    while i < cnt:
        answer = answer + word
        i = i + 1
    return answer
