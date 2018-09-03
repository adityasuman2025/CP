Q = int(input())

q = []

for i in range(Q):
    data = input().split()
    job = int(data[0])
     
    if job == 1: #adding element into the queue
        val = int(data[1])        
        q.append(val)
    elif job ==2: #deleting element from the queue
        q.pop(0) #removes the first element in the queue
    elif job ==3: #printing the first element in the queue
        print(q[0])