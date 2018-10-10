def countRotation(arr):
	minm = min(arr)
	for i in range(len(arr)):
		if arr[i] == minm:
			return i

#main functionality
arr = [9,10,1,1,2,5,6,7,7,8]
print(arr)

count = countRotation(arr)
print(count)
