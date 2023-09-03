import java.util.*;
import java.io.*;

class CNode
{
	int data;
	CNode next, random;

	cNode(int data)
	{
		this.data = data;
	}
}

class copyLinkedListWithRandomPointers
{
	CNode copy(cNode head)
	{
	// Initialize two references
		CNode curr = head;
		CNode copiedCurr = null;

	// Hash map which contains node to node mapping of 
        // original and clone linked list. 
		HashMap<CNode, CNode> map = new HashMap<>();

    // Traverse the original list and make a copy of that and store it in hash map    	
		while(curr != null)
		{
			copiedCurr = new CNode(curr.data);
			map.put(curr, copiedCurr);

			curr = curr.next;
		}

	// Adjusting the original list reference to do transverse from head
		curr = head;

    // Traversal of original list again to adjust the next 
        // and random references of clone list using hash map.
		while(curr != null)
		{
			copiedCurr = map.get(curr);;
			copiedCurr.next = map.get(curr.next);
			copiedCurr.random = map.get(curr.random);

			curr = curr.next;
		}

	//return the head reference of the clone list.
		return map.get(head);
	}
}