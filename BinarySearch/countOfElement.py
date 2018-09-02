def Index(arr, to_find, forFirstIndex):
	start = 0;
	end = len(arr) - 1

	result = -1
	while start <=end:
		mid = int(start + (end-start)/2)
		if arr[mid] == to_find:
			result = mid
			if forFirstIndex:
				end = mid-1
			else:
				start = mid+1
		elif to_find < arr[mid]:
			end = mid-1
		else:
			start = mid + 1

	return result

#main functionality
arr = [8,9,7,5,2,10,7,1,6]
arr.sort()

print(arr)
firstIndex = Index(arr, 11, True)
lastIndex = Index(arr, 11, False)
# print(firstIndex)
# print(lastIndex)

count = lastIndex - firstIndex +1
if firstIndex == -1 and lastIndex == -1:
	count = 0

print("count is: " + str(count))