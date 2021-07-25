# 로직은 맞는것 같은데 계속 17점이 나와서 수정함..
# 아래처럼..

#cityCount = int(input()); # 도시의 개수
#distance = input().split();  #도로의 길이
#cityList =  input().split(); #리터당 가격

#city_min = cityList[0]; # 첫번째는 무조건 필요
#answer = 0;
#for i in range(cityCount-1): # 마지막도 필요없으니까 -1
#    if city_min > cityList[i]: # 가장 싼곳에서 사야 이들
#        city_min = cityList[i];
#    answer += (int(city_min) * int(distance[i]));
    
#print(answer);

#################################################
# 처음 받을때 값을 int 로 받아야 하는듯.. 아마 비교할때 문제가 되는것 같은데
#정확하게 모르겠음 
cityCount = int(input()) # 도시의 개수
distance = list(map(int, input().split())) #도로의 길이
cityList = list(map(int, input().split())) #리터당 가격

city_min = cityList[0] # 첫번째는 무조건 필요
answer = 0
for i in range(cityCount-1):# 마지막도 필요없으니까 -1
    if city_min > cityList[i]:  # 가장 싼곳에서 사야 이들
        city_min = cityList[i]
    answer += (city_min * distance[i])
    
print(answer)