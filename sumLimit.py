N = int(input())

for i in range(N):
    lenn, pro = input().split()
    pro = int(pro)
    data = list(map(int, input().split()))
    data_org = data.copy()
    
    lenn = int(len(data))
    
    for j in range(1, lenn):
        data[j] = data[j-1]+data[j]
        
    #print(data)

#tym limit excceded    
    count = []
    for j in range(lenn):
        subs = 0 if j==0 else data[j-1]
        for k in range(j, lenn):
            if data[k]-subs > pro:
                count.append(k-j+1)
                break;
                
    
    print(min(count))