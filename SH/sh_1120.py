import sys
str1, str2 = input().split()
cnt = 0
bnt = 10000
check = 0

if (len(str1) > 50 or len(str2) >50):
    sys.exit(0)
elif len(str1) > len(str2):
    sys.exit(0)

check = len(str2) - len(str1)

while check >= 0:
    for x in range(len(str1)):
        if str1[x] != str2[x+check]:  
            cnt += 1

   
    if bnt > cnt:
        bnt = cnt

    check -= 1
    cnt = 0
       
    
print(bnt)


