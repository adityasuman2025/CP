class Node:
	def __init__(self, data=None):
		self.data = data
		self.left = None
		self.right = None

#inserting node is BST
def insert(root, val):
	if root.data ==None:
		root.data = val

	if val < root.data:
		if root.left == None:
			root.left = Node(val)
		else:
			insert(root.left, val)
	elif val >root.data:
		if root.right == None:
			root.right = Node(val)
		else:
			insert(root.right, val)

# depth-first inorder transversal
def inOrder(root):
	if root.left != None:
		inOrder(root.left)
	
	print(root.data, end=", ")

	if root.right !=None:
		inOrder(root.right)

# depth-first preorder transversal
def preOrder(root):
	print(root.data, end=", ")

	if root.left != None:
		inOrder(root.left)
	
	if root.right !=None:
		inOrder(root.right)

#checkin if BST or not
listt = []
def inOrderCheck(root):
	if root.left !=None:
		inOrderCheck(root.left)

	listt.append(root.data)

	if root.right !=None:
		inOrderCheck(root.right)

def checkBinary(root):
	inOrderCheck(root)

	for i in range(len(listt)-1):
		if listt[i] > listt[i+1]:
			return False
	return True

#breadth first search or level-order transversal
def levelOrder(root):
	if root == None:
		return

	q = [] #queue
	q.append(root)
	while len(q) !=0:
		current = q[0]

		print(current.data, end=" ")

		if current.left:
			q.append(current.left)

		if current.right:
			q.append(current.right)	

		q.pop(0)

#height of tree
def height(root):
	if root == None:
		return -1

	lHeight = height(root.left)
	rHeight = height(root.right)

	return max(lHeight, rHeight) +1

root = Node()
insert(root, 10)
insert(root, 5)
insert(root, 6)
insert(root, 11)
insert(root, 15)

inOrder(root)
print()
preOrder(root)

print()
print(checkBinary(root))

levelOrder(root)

print()
print(height(root))