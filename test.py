#code

N = int(input())

pro_arr = []
data_arr = []
for i in range(N):
    lenn, pro = input().split()
    data = list(map(int, input().split()))
    
    lenn = int(lenn)
    pro = int(pro)
    
    count = 0
    for j in range(lenn):
        prodd = 1
        for k in range(j, lenn):
            prodd = prodd*data[k]
            if prodd<=pro:
                count +=1
    print(count)