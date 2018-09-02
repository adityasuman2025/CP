#using recursion
def search(arr, start, end, to_search):
	if start>end:
		return -1

	mid = int(start + ((end-start)/2))	

	if arr[mid] == to_search:
		return mid
	elif to_search > arr[mid]:
		return search(arr, mid+1, end, to_search)
	else:
		return search(arr, start, mid-1, to_search)


#using itteration
def search(arr, to_search):
	start = 0
	end = len(arr) - 1

	while start<=end:
		mid = int(start + ((end-start)/2))

		if arr[mid] == to_search:
			return mid
		elif to_search < arr[mid]:
			end = mid -1
		else:
			start = mid+1

	return -1

#main functionality
arr = [8,9,7,5,2,10,7,1,6]
arr.sort()

#ans = search(arr, 0, len(arr)-1, 7) #end will the index of the last element
#function overloading is not allowed in python

ans2 = search(arr, 1)
print(ans2)