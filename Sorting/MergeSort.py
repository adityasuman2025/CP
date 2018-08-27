def mergeSort(arr):

	length = int(len(arr))
	mid= int(len(arr)/2)

	if length <2:
		return arr

	left = []
	right = []

	for i in range(mid):
		left.append(arr[i])

	for j in range(length-mid):
		right.append(arr[mid+j])

	# print(left)
	# print(right)

	mergeSort(left)
	mergeSort(right)
	merge(left, right, arr)

	return arr


def merge(left, right, arr):
	i=0
	j=0
	k=0

	left_len = len(left)
	right_len = len(right)
	arr_len = len(arr)

	while i< left_len and j< right_len:
		if left[i] < right[j]:
			arr[k] = left[i]
			i +=1
		elif left[i] > right[j]:
			arr[k] = right[j]
			j +=1
		
		k +=1

	while i<left_len:
		arr[k] = left[i]
		i +=1
		k +=1

	while j<right_len:
		arr[k] = right[j]
		j +=1
		k +=1

arr = [8,5,9,7,6,2,4,1,3]

mergeSort(arr)
print(arr)