N = int(input())

for i in range(N):
    lenn, pro = input().split()
    pro = int(pro)
    data = list(map(int, input().split()))
    data_org = data.copy()
    
    lenn = int(len(data))
   
    for j in range(1, lenn):
        data[j] = data[j-1]*data[j]
        
    #print(data)

#tym limit excceded    
    count = 0
    for j in range(lenn):
        divisor = 1 if j==0 else data[j-1]
        for k in range(j, lenn):
            if data[k]/divisor < pro:
                count +=1
            else:
                break
            
#trying binary search
    # count = 0
    
    # start = 0
    # end = lenn -1
    
    # while start <= end:
    #     mid = start + int((end-start)/2)
    #     divisor = 1 if start == 0 else data[mid-1]
        
    #     if int(int(data[mid])//int(divisor)) <= int(pro):
    #         count += (mid+1)
    #         start = mid+1
    #     else:
    #         end = mid-1
            
    
    # #print(data_org)        
    # for j in data_org:
    #     if j <pro:
    #         count +=1
            
    print(count)