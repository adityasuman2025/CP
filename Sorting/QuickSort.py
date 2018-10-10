count = 0;

def quicksort(arr, start, end):
	if start<end:
		pIndex = partition(arr, start, end)
		quicksort(arr, start, pIndex-1)
		quicksort(arr, pIndex+1, end)

def partition(arr, start, end):
	pivot = arr[end]
	pIndex = start

	comp = end-start
	global count
	count += comp-1

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

sample = int(input())
arr = []
for i in range(sample):
	arr.append(int(input()))

quicksort(arr, 0, len(arr)-1)
print(arr)
print(count)