def findNonDupl(arr):
	listt = []
	dictt ={}
	for i in range(0,len(arr)-1):
		dictt[i] = arr[i]
		if arr[i] == arr[i+1]:
			listt.append(arr[i])
	dictt[len(arr)-1] = arr[len(arr)-1]

	# print(listt)
	# print(dictt)

	for i in dictt.keys():
		val = dictt.get(i)

		if val not in listt:
			print(str(val) + " is found simgle at index: " + str(i))

#main functionality
arr = [0,1,1,2,9,2,3,3,4,4,5,5]

print(arr)
findNonDupl(arr)
#print(ans)