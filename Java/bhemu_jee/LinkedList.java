class LLNode {
    String data;
    LLNode nextNodeAddress;

    LLNode(String value) {
        data = value;
    }

    void linkNode(LLNode nextNode) {
        nextNodeAddress = nextNode;
    }
}

class LinkedList {
    public static void main(String args[]) {
    //     LLNode node1 = new LLNode("bhemu");
    //     LLNode node2 = new LLNode("kutta");
    //     LLNode node3 = new LLNode(null);
    //     LLNode node4 = new LLNode("chua");
        
    //     node1.data = "bhebhepu";
    //     node1.nextNodeAddress = node2; // node1.linkNode(node2);

    //     node3.data = "billi";
    //     node3.linkNode(node1);
        
        // node2.nextNodeAddress= node3;

        // node4.nextNodeAddress = node3;

        // System.out.println(node1.data);
        // System.out.println(node2.data);
        // System.out.println(node1.nextNodeAddress.data); //node2.data
        // System.out.println(node3.data);
        // System.out.println(node3.nextNodeAddress.data); //node1.data

        //creating a linked list
        LLNode start = new LLNode("1");
        LLNode pointer = start;

        for (int i = 2; i <= 50; i++) {
            LLNode newNode = new LLNode(Integer.toString(i));
            pointer.nextNodeAddress = newNode;
            pointer = newNode;
        }
        //pointer will be at 50 at the end of the loop
        
        //printing the linked list
        // print(start);

        //printing the linked list in reverse order
        // printReverse(start);

        //reversing the linked list
        // LLNode ka = reverse(null,start,null);
        // //prev will be at 50 at the end of the loop, curr and next will be null
        // //printing the linked list
        // print(ka);
        
        LLNode pointer1 = start; 
        while (pointer1 != null) { 
            pointer1 = pointer1.nextNodeAddress;      
            boolean nodo = search(pointer1.data);
            System.out.println("Ans is " + nodo); 
        }
       
        
    }

    static void see(LLNode start) {
        LLNode pointer = start; 
        while (pointer != null) { 
            System.out.println(pointer.data + "->");
            pointer = pointer.nextNodeAddress;        
        }
        System.out.println(" ");
    }

    public static LLNode reverse(LLNode prev, LLNode curr, LLNode next) {
        while (curr != null) {
            next = curr.nextNodeAddress;
            curr.nextNodeAddress = prev;

            prev = curr;
            curr = next;
        }   
        return prev;
    }
    
    static void print(LLNode start) {
        LLNode iterator = start; // looper or pointer
        while (iterator != null) { 
            System.out.print(iterator.data + " -> ");
            iterator = iterator.nextNodeAddress;
        }
        System.out.println(" ");
    }

    static void printReverse(LLNode current) {
        if (current == null) {
            System.out.println("");
            return;
        }
        printReverse(current.nextNodeAddress);

        System.out.print(current.data + " <- ");
    }
    static boolean search (String kauaa) {
        if (Integer.parseInt(kauaa) == 20) {
            return true;
        } else {
            return false;
        }
    }
}