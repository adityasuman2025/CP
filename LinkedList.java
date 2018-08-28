class Node
{
	int data;
	Node next;

	public Node(int nodeData)
	{
		this.data = nodeData;
		this.next = null;
	}

	public Node(int nodeData, Node nodeNext)
	{
		this.data = nodeData;
		this.next = nodeNext;
	}

//getters and setters
	public void setData(int newData)
	{
		this.data = newData;
	}

	public void setNext(Node newNext)
	{
		this.next = newNext;
	}

}

public class LinkedList
{
	Node head;
	int count;

//constructor
	public LinkedList()
	{
		head = null;
		count = 0;
	}

	public LinkedList(Node node)
	{
		head = node;
		count =1;
	}

//add method
	public void add(int newData)
	{
		Node temp = new Node(newData);

		Node current = head;

		if(current == null)
		{
			current = temp;
			count++;
		}
		else
		{
			while(current.next !=null)
			{
				current = current.next;
			}

			current.next = temp;
			count++;
		}		
	}

//get method
	public void get(int index)
	{
		if(index <=0)
		{
			System.out.println(-1);
		}
		else
		{
			Node current = head;
			int c=1;
			while(c<index)
			{
				c++;
				head = head.next;
			}

			System.out.println(head.data);	
		}
	}

//size method
	public void size()
	{
		System.out.println(count);
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

//remove method
	public void remove()
	{
		Node current = head;
		if(current.next == null)
		{
			current = null;
		}
		else
		{
			while(current.next.next!=null)
			{
				current = current.next;
			}

			current.next = null;
			count--;
		}		
	}

//print method
	public void print()
	{
		Node current = head;

		if(current == null)
		{
			System.out.println("LinkedList is empty");
		}
		else
		{
			while(current.next !=null)
			{
				System.out.println(current.data);
				current = current.next;
			}

			System.out.println(current.data);
		}		
	}

//main function
	public static void main(String[] args) 
	{
		Node node = new Node(89);
		LinkedList list = new LinkedList(node);
		list.print();
		list.size();
		list.add(78);
		list.get(1);
		list.size();
		list.remove();
		list.size();
	}
}