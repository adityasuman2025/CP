#function to check if strings differ by only by one character(letter)
def isAdjacent(a, b): # a is compared with b
	count =0

	for i in range(len(a)):
		if a[i] != b[i]:
			count +=1

		if count>1:
			break
	return True if count == 1 else False

# A queue item to store word and minimum chain length to reach the word. 
class QItem():
	def __init__(self, word, leng):
		self.word = word
		self.leng = leng


#returns length of the minimum moves (shortest chain) to reach target from start
def shortestChainLength(start, target, Dictt):
	#creating a queue and appending the start word in the queue
	Q = []
	item = QItem(start, 1)
	Q.append(item)

	while(len(Q) >0):
		curr = Q.pop()

		#going through the words of the given dictionary and adding that word in the queue if it has differance of only one character 
		for it in Dictt:
			temp = it

			#checking if that word is adjacent to the current word(popped from the queue)
			if isAdjacent(curr.word, temp):
				item.word = temp
				item.leng +=1
				Q.append(item) # adding the new word in the queue

				Dictt.remove(temp) #removing that word from the dictinoary to avoid repeatition

				if temp == target:
					return item.leng

	return "Not possible"

D = [] 
D.append("poon") 
D.append("plee") 
D.append("same") 
D.append("poie") 
D.append("plie") 
D.append("poin") 
D.append("plea") 
start = "toon"
target = "plea"
print ("Length of shortest chain is: " + (str)(shortestChainLength(start, target, D)))


