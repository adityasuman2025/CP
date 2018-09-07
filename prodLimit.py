N = int(input())

for i in range(N):
    lenn, k = input().split()
    k = int(k)
    data = list(map(int, input().split()))
    
    lenn = int(len(data))
   
# doing prefix product
#     for j in range(1, lenn):
#         data[j] = data[j-1]*data[j]
        
# tym limit excceded    
#     count = 0
#     for j in range(lenn):
#         divisor = 1 if j==0 else data[j-1]
#         for k in range(j, lenn):
#             if data[k]/divisor < pro:
#                 count +=1
#             else:
#                 break
#     print(count)

#trying something else
    pro = 1
    start = 0
    ans = 0
    for j in range(lenn):
        pro *=data[j]
        if pro>=k:
            while pro>=k:
                ans += (j-start)
                pro /=data[start]
                start +=1 

    if pro>=1:
        r = lenn -start
        ans += int((r*(r+1))/2)

    print(ans)
        