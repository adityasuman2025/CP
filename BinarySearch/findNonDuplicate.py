def findNonDuplicate(arr):
	dic ={}
		
	for i in range(len(arr)):
		x = arr[i]
		if x in dic:
			val = dic.get(x)
			dic[x] = val+1
		else:
			dic[x] = 1

	#print(dic)

	listt = []
	for i in dic.keys():
		value = dic.get(i)
		if value == 1:
			listt.append(i)

	#print(listt)

	for i in range(len(arr)):
		ele = arr[i]
		if ele in listt:
			print(str(arr[i]) + " is single and is at index: " + str(i))

#main functionality
arr = [0,1,1,2,9,2,3,3,4,4,5,6]
arr.sort()

print(arr)
findNonDuplicate(arr)
#print(ans)