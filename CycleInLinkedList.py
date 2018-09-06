def checkCycle(root):
	if root == None:
		return False

	slow = root
	fast = root.next

	while fast != None && fast.next !=None && slow !=None:
		if fast == slow:
			return True

		fast = fast.next.next
		slow = slow.next

	return False