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
        LLNode node1 = new LLNode("bhemu");
        LLNode node2 = new LLNode("kutta");
        LLNode node3 = new LLNode(null);
        LLNode node4 = new LLNode("chua");
        
        node1.data = "bhebhepu";
        node1.nextNodeAddress = node2; // node1.linkNode(node2);

        node3.data = "billi";
        node3.linkNode(node1);
        
        // node2.nextNodeAddress= node3;

        node4.nextNodeAddress = node3;

        // System.out.println(node1.data);
        // System.out.println(node2.data);
        // System.out.println(node1.nextNodeAddress.data); //node2.data
        // System.out.println(node3.data);
        // System.out.println(node3.nextNodeAddress.data); //node1.data
      
        LLNode iterator = node4;
        while (iterator != null) { 
            // for ( ; iterator != null ; ) {}
            System.out.println(iterator.data);
            iterator = iterator.nextNodeAddress;
        }
    }
}