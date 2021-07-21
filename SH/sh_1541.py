#입력값 받기
str = input()

answer = 0; #최종 출력값 초기화
tmp = 0; #괄호안 계산 값

list = str.split('-'); # 마이너스로 리스트 생성  마이너스 뒤에 무조건 괄호를 열면 최소값

for a in range(len(list)):
    lista=list[a].split('+');    # 괄호안 값을 더해주기 위해 플러스로 구분한 이차 리스트 생성
    for b in lista:
            tmp += int(b);  #괄호 안 값 더해주기
            
    if a == 0 : #만약 첫번째 값일 경우 -가 있을 수 없기때문
        answer += tmp;
    else:
        answer -=tmp ; 
    tmp = 0; # 괄호안 값 초기화

print(answer);
