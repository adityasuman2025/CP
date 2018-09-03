fptr = open('t.txt', 'w')

Q = int(input())

stack = []

for i in range(Q):
    data = input().split()
    job = int(data[0])
     
    if job == 1: #adding element into the stack
        val = int(data[1])        
        stack.append(val)
    elif job ==2: #deleting element from the stack
        if len(stack) !=0:
            stack.pop()
    elif job ==3: #printing the max
        #print(max(stack))
        fptr.write(str(max(stack)) + '\n')

fptr.close()   