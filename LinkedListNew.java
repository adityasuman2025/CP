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
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
	}

//main function
	public static void main(String[] args) 
	{
		LinkedListNew ls = new LinkedListNew(1);
		ls.append(2);
		ls.prepend(3);
		ls.append(4);
		ls.prepend(42);
		ls.remove(10);
		ls.print();
	}
}