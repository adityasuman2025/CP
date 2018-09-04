#code

N = int(input())

arr = []
for i in range(N):
    str = input()
    arr.append(str)

for i in arr:
    string = i
    dictt = {}
    for char in string:
        if dictt.get(char) == None:
            dictt[char] = 1
        else:
            val = dictt[char]
            dictt[char] = val+1
    #print(dictt)
    
    count = 0
    for char in string:
        if dictt[char] > 1:
            print(char)
            count +=1
            break;

    if count ==0:
        print(-1)