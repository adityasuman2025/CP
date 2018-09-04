N = int(input())
for i in range(N):
    lenn, pro = input().split()
    pro = int(pro)
    data = list(map(int, input().split()))
    
    # data = []
    # for i in data2:
    #     if i not in data:
    #         data.append(i)
        
    lenn = int(len(data))
   
    count = 0
    for j in range(lenn):
        #temp = []
        prodd = 1
        for k in range(j, lenn):
            temp_data = data[k]
           # if temp_data not in temp:
                #temp.append(temp_data)
            prodd = prodd*temp_data
            if prodd<pro:
                count +=1
            else:
                break
            # else:
            #     break
        #print(temp)
    print(count)