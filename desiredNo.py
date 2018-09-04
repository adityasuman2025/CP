import re

N = int(input())

regex = re.compile("[0456789]+")

for i in range(N):
    lenn = int(input())
    arr = input().split()
    
    count = 0
    res = []
    for k in range(lenn):
        temp = arr[k]
        if regex.search(temp) == None:
            count +=1
            #print(int(temp), end=" ")
            res.append(int(temp))
            
    if count ==0:
        print(-1, end=" ")
    else:
        res.sort()
        for l in res:
            print(l, end=" ")
        
    print()
    
  