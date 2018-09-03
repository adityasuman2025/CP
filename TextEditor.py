fptr = open('t.txt', 'w')

Q = int(input())

string = []
history = []

for i in range(Q):
    temp = []
    temp1 = []
    temp2 = []
    
    data = input().split()
    job = int(data[0])
     
    if job == 1: #adding element into the stack
        val = data[1]
        
        for i in val:
            string.append(i)
            
        temp1 = string.copy()    
        history.append(temp1)
    elif job ==2: #deleting element from the stack
        val = int(data[1])
        
        for i in range(val):
            string.pop()
            
        temp2 = string.copy()   
        history.append(temp2)
    elif job ==3: #printing the kth element of the string stack
        val = int(data[1])        
        #print(string[val-1])
        fptr.write(str(string[val-1]) + '\n')
    elif job ==4:
        if len(history) <2:
            string = []
            history.pop()
        else:
            temp = history[-2].copy()
            string =temp
            history.pop()       
        
    #print(history)
   
fptr.close()        