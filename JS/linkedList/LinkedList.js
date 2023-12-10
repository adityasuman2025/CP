class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}


class LinkedList {
    constructor() {
        this.head = null;
    }

    print = function() {
        let curr = this.head, str = "";
        while (curr) {
            str += (curr.val + " -> ")
            curr = curr.next;
        }

        str = str.substring(0, str.length - 3);
        console.log("print:", str)
    }

    printFromNode(node) {
        if (!node) return;

        let curr = node, str = "";
        while (curr) {
            str += (curr.val + " -> ")
            curr = curr.next
        }
        str = str.substring(0, str.length - 3);
        console.log("printFromNode:", str)
    }

    add = function(val) {
        if ([undefined, null].includes(val)) return;

        if (this.head === null) this.head = new Node(val);
        else {
            let curr = this.head;
            while (curr.next) curr = curr.next;

            curr.next = new Node(val);
        }
    }

    insertAtIndex(index, val) {
        if ([undefined, null].includes(index) || [undefined, null].includes(val)) return;

        const node = new Node(val);

        if (this.head === null) this.head = node;
        else {
            if (index === 0) {
                node.next = this.head;
                this.head = node;
                return;
            }

            let c = 1, curr = this.head;
            while (c < index && curr.next) {
                c++;
                curr = curr.next;
            }
            let next = curr.next;
            curr.next = node;
            node.next = next;
        }
    }

    remove = function(val) {
        if ([undefined, null].includes(val)) return;

        let curr = this.head, prev = null;
        while (curr) {
            if (curr.val === val) {
                if (!prev) { // to remove first element
                    this.head = curr.next;
                    curr = null; // freeing memory
                } else prev.next = curr.next;

                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    removeAtIndex(index) {
        if ([undefined, null].includes(index) || this.head === null) return;

        if (index === 0) {
            this.head = this.head.next;
            return;
        }

        let curr = this.head.next, prev = this.head, c = 1;
        while (c < index && curr) {
            prev = curr;
            curr = curr.next;
            c++;
        }

        if (curr) prev.next = curr.next;
        else console.log("no element found at index", index);
    }

    removeNthFromEnd(n) {
        let curr1 = this.head, length = 0
        while (curr1) {
            length++;
            curr1 = curr1.next;
        }

        let curr = this.head, prev = null;
        let c = length - n;
        while (c--) {
            prev = curr;
            curr = curr.next
        }

        if (prev) prev.next = curr.next;
        else this.head = curr.next
    }

    removeMiddle() {
        let curr = this.head, c = 0;
        while (curr) {
            curr = curr.next;
            c++;
        }

        curr = this.head, prev = null;
        let mid = parseInt(c / 2);
        while (mid) {
            prev = curr;
            curr = curr.next;
            mid--;
        }
        if (prev) prev.next = curr.next;
        else this.head = curr.next;

        return this.head;
    }

    indexOf(val) {
        if ([undefined, null].includes(val) || this.head === null) return;

        let c = 0, curr = this.head;
        while (curr) {
            if (curr.val === val) return c;

            curr = curr.next;
            c++;
        }

        return -1;
    }

    isEmpty() {
        if (this.head === null) return true;

        return false;
    }

    length() {
        if (this.head === null) return 0;

        let curr = this.head, c = 0;
        while (curr) {
            curr = curr.next;
            c++;
        }

        return c;
    }

    reverse() {
        if (this.head === null) return;

        let curr = this.head, prev = null, next = null;
        while (curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;

            curr = next;
        }

        this.head = prev;
    }

    getMiddle() {
        if (!head) return head;

        let slow = head, fast = head;
        while (fast && fast.next) {
            slow = slow.next;
            fast = fast.next.next
        }

        return slow;
    }

    printReverse(node) {
        if (!node) return;

        this.printReverse(node.next);

        console.log(node.val);
    }

    rotateLeftBy(k) {
        if ([undefined, null].includes(k) || this.head === null) return;

        k = k % this.length();
        if (k === 0) return;

        let oldHead = this.head;
        let curr = this.head, prev = null, c = 0;
        while (c < k && curr) {
            prev = curr;
            curr = curr.next;
            c++;
        }
        this.head = curr;
        prev.next = null;

        while (curr.next) curr = curr.next;
        curr.next = oldHead;
    }

    rotateRightBy(k) {
        if ([undefined, null].includes(k) || this.head === null) return;

        let len = this.length();
        k = k % len;
        if (k === 0) return;

        let oldHead = this.head;

        let c = 0, curr = this.head;
        while ((c < len - k - 1) && curr) {  // go to the element at length-k-1 index (curr), element next to it will become the new head
            curr = curr.next;
            c++;
        }
        this.head = curr.next;
        curr.next = null; // breaking its bond with the new head

        let temp = this.head;
        while (temp.next) temp = temp.next; // going to the end of the new head linked list
        temp.next = oldHead; // attaching last element to the old head
    }

    reverseInGroup(head, k) {
        if (!this.head) return;

        let len = this.length();
        if (k > len) return head;

        function rigUtil(head, k) {
            if (!head) return head;

            let oldHead = head;
            let curr = head, prev = null, next = null, c = 0;
            while (curr && c < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;

                curr = next;
                c++;
            }
            oldHead.next = rigUtil(next, k);

            return prev;
        }

        return rigUtil(this.head, k);
    }

    createCycle() {
        let curr = this.head, head = this.head;
        while (curr.next) curr = curr.next;

        curr.next = head;
    }

    detectCycle() {
        if (!this.head) return false;

        let slow = this.head, fast = this.head.next;
        while (fast !== null && fast.next !== null) {
            if (slow === fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}



const ll = new LinkedList();

ll.add(1);
ll.add(4);
ll.insertAtIndex(0, 0);
ll.insertAtIndex(2, 2);
ll.add(5);
ll.insertAtIndex(3, 3);
ll.insertAtIndex(10, 6);

// // ll.remove(2.5);
// // ll.remove(10);
// // ll.remove(0);
// ll.removeAtIndex(6);

// const index = ll.indexOf(5);
// console.log("index:", index);

const isEmp = ll.isEmpty();
console.log("isEmp:", isEmp);

const len = ll.length();
console.log("len:", len);

// ll.reverse();
// ll.printReverse(ll.head);

// ll.rotateLeftBy(2);
// ll.rotateRightBy(2);

// const newHead = ll.reverseInGroup(ll.head, 4);
// ll.printFromNode(newHead);

ll.print();

// ll.createCycle();
// const hasCycle = ll.detectCycle();
// console.log("hasCycle:", hasCycle);