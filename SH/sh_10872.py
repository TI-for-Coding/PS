import sys

a= int(input())
answer = 1

def factorial(arg1,answer):
    answer = answer * arg1
    return answer

while(a>0):
    answer = factorial(a,answer)
    a = a-1

print(answer)

