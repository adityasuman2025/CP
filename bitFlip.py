N = int(input())

def f(bit): #101010...
    count = 0
    for i in range(0, len(bit), +2):
        if bit[i] != "1":
            count +=1
            
    for i in range(1, len(bit), +2):
        if bit[i] !="0":
            count +=1
    return count
    
def s(bit): #010101...
    count = 0
    for i in range(0, len(bit), +2):
        if bit[i] != "0":
            count +=1
            
    for i in range(1, len(bit), +2):
        if bit[i] !="1":
            count +=1
    return count
    
for i in range(N):
   bit = input()
   
   a = f(bit)
   b = s(bit)
   
#   print(a)
#   print(b)
   
   print(min(a, b))