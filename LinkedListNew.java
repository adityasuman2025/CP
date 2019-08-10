class NodeNew
{
	NodeNew next;
	int data;

	public NodeNew(int nodeData)
	{
		this.data = nodeData;
	}
}

public class LinkedListNew
{
	NodeNew head;

	LinkedListNew(int nodeData)
	{
		head = new NodeNew(nodeData);
	}

//to append a new node
	public void append(int nodeData)
	{
		NodeNew temp = new NodeNew(nodeData);

		NodeNew current = head;

		if(current == null) //if linked list is empty
		{
			head = temp;
			return;
		}

		while(current.next != null)
		{
			current = current.next;
		}

		current.next = temp;
	}

//to prepend a new node
	public void prepend(int nodeData)
	{
		NodeNew temp = new NodeNew(nodeData);

		NodeNew current = head;

		if(current == null) //if linked list is empty
		{
			head = temp;
			return;
		}

		temp.next = head;
		head = temp;
	}

//to remove a node with a value
	public void remove(int nodeData)
	{
		NodeNew current = head;

		if(current == null) //if linked list is already empty
		{			
			return;
		}

		if(head.data == nodeData) //if to delete head node
		{
			head = head.next;
			return;
		}

		while(current.next != null)
		{
			if(current.next.data == nodeData)
			{
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

//isEmpty method
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}

		return false;
	}	

//to rotate linked list in left direction
	void rotateLeft(int k)
	{
		NodeNew current2 = head;
		NodeNew current = head;

	//getting size of the linked list
		int size = 0;

		if(current2 == null)
			size = 0;

		while(current2.next !=null)
		{
			current2 = current2.next;
			size++;
		}
		size++;		

		if(k>=size)
			k = k%size;

		if(k == 0)
			return;

	//going to the kth node	
		int count = 1;
		while(current != null)
		{
			if(count<k)
			{
				current = current.next;
				count++;
			}
			else
			{
				break;
			}			
		}

		if(current == null) //when k is greater or equal to size of linked list
			return;

		NodeNew kthNode = current;

	//going to the last element of the linked list and linking last element to head
		while(current.next !=null)
		{
			current = current.next;
		}
		current.next = head;

	// making the element next to the kth element as head 	
		head = kthNode.next;

	//making next of the kth element null
		kthNode.next = null;
	}

//to rotate linked list in right direction
	void rotateRight(int k)
	{		
		NodeNew current2 = head;
		NodeNew current = head;

	//getting size of the linked list
		int size = 0;

		if(current2 == null)
			size = 0;

		while(current2.next !=null)
		{
			current2 = current2.next;
			size++;
		}
		size++;		

		if(k>=size)
			k = k%size;

		if(k == 0)
			return;
		
	//going to the kth node	
		int count = 1;
		while(current != null)
		{
			if(count<size-k)
			{
				current = current.next;
				count++;
			}
			else
			{
				break;
			}			
		}

		if(current == null) //when k is greater or equal to size of linked list
			return;

		NodeNew kthNode = current;

	//going to the last element of the linked list and linking last element to head
		while(current.next !=null)
		{
			current = current.next;
		}
		current.next = head;

	// making the element next to the kth element as head 	
		head = kthNode.next;

	//making next of the kth element null
		kthNode.next = null;
	}

//to reverse a linked list
	void reverse()
	{
		NodeNew prev = null;
		NodeNew curr = head;
		NodeNew next = null;

		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		head = prev;		
	}

//to print the linkedlist
	public void print()
	{
		NodeNew current = head;

		if(current == null) //if linked list is already empty
		{		
			System.out.println("LinkedList is empty");	
			return;
		}

		while(current.next != null)
		{
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print(current.data + " ");
 
		System.out.println();
	}

//main function
	public static void main(String[] args) 
	{
		LinkedListNew ls = new LinkedListNew(1);
		ls.append(2);
		ls.prepend(3);
		ls.append(4);
		ls.prepend(42);
		ls.print();

		ls.reverse();
		ls.print();

		// ls.rotateLeft(5);
		// ls.print();

		// ls.rotateRight(5);
		// ls.print();
	}
}