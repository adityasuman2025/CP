def quicksort(arr, start, end):
	if start<end:
		pIndex = partition(arr, start, end)
		quicksort(arr, start, pIndex-1)
		quicksort(arr, pIndex+1, end)

def partition(arr, start, end):
	pivot = arr[end]
	pIndex = start

	for i in range(start, end):
		if arr[i]<=pivot:
			temp = arr[pIndex]
			arr[pIndex] = arr[i]
			arr[i] = temp

			pIndex +=1

	temp_end = pivot
	arr[end] = arr[pIndex]
	arr[pIndex] = temp_end

	return pIndex

arr = [8,5,9,7,6,2,4,1,3]

quicksort(arr, 0, len(arr)-1)
print(arr)