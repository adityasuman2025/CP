class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
    }

    add(element) {
        if (this.head == null) {
            this.head = new Node(element);
        } else {
            let curr = this.head;
            while (curr.next) curr = curr.next;

            curr.next = new Node(element);
        }
    }

    insertAtIndex(element, index) {
        const node = new Node(element);

        if (this.head == null) {
            this.head = node;
        } else {
            let curr = this.head;
            if (index == 0) {
                node.next = this.head;
                this.head = node;
                return;
            }

            let i = 1;
            while (i < index && curr.next != null) {
                curr = curr.next;
                i++;
            }
            let currOldNext = curr.next;
            curr.next = node;
            node.next = currOldNext
        }
    }

    removeFromIndex(index) {
        let curr = this.head;

        if (curr == null) {
            return;
        } else {
            if (index == 0) {
                this.head = curr.next;
                return;
            }
            let i = 1;
            while (i < index && curr.next != null) {
                curr = curr.next;
                i++;
            }

            if (curr.next) {
                let currNextNext = curr.next.next;
                curr.next = currNextNext;
            } else {
                console.log("no element found at index", index);
            }
        }
    }

    removeElement(element) {
        if (!element) {
            console.log("plz give a valid element");
            return;
        }

        let curr = this.head;
        let prev = null;
        while (curr) {
            if (curr.value === element) {
                if (prev) {
                    prev.next = curr.next;
                } else {
                    this.head = curr.next;
                }
                
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    indexOf(element) {
        let curr = this.head;

        let index = 0;
        while (curr) {
            if (curr.value == element) return index;
            curr = curr.next;
            index++;
        }

        return -1;
    }

    isEmpty() {
        let count = 0;
        let curr = this.head;
        while (curr) {
            curr = curr.next;
            count++;
        }

        return count == 0;
    }

    length() {
        let count = 0;
        let curr = this.head;
        while (curr) {
            curr = curr.next;
            count++;
        }

        return count;
    }

    reverse() {
        let curr = this.head;

        let prev = null;
        let next = null;
        while (curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;

            curr = next;
        }

        this.head = prev;
    }

    reverseInGroup(head, k) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 
        // k = 3
        // 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7

        if (head !== "ka") {
            if (head == null || head.next == null) return head;
        }
        
        let curr = head === "ka" ? this.head : head;
        let prev = null;
        let next = null;

        let i = 0;
        while (i< k && curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            i++;
        }

        if (head === "ka") {
            this.head.next = this.reverseInGroup(curr, k);
            this.head = prev;
        } else {
            head.next = this.reverseInGroup(curr, k);
        }

        return prev;
    }

    printReverse(node) {
        if (node === null) return;

        if (node === undefined) {
            this.printReverse(this.head);
        } else {
            this.printReverse(node.next);
            console.log(node.value);
        }
    }

    rotateRightBy(k) {
        let length = this.length();
        k = k % length;
        if (!k) return;

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 
        // k = 3
        // 7 -> 8 -> 9 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

        let head = this.head;
        let curr = this.head;

        let i = 1;
        while ((i < length-k) && curr) {
            curr = curr.next;
            i++;
        }
        let newHead = curr.next; //7
        let nextCurr = curr.next; //7
        curr.next = null;

        while (nextCurr.next) {
            nextCurr = nextCurr.next;
        }
        nextCurr.next = head;

        this.head = newHead;
    }

    rotateLeftBy(k) {
        let length = this.length();
        k = k % length;
        if (!k) return;

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 
        // k = 3
        // 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 1 -> 2 -> 3

        let head = this.head;
        let curr = this.head;

        let i = 1;
        while ((i < k) && curr) {
            curr = curr.next;
            i++;
        }
        let newHead = curr.next; //4
        curr.next = null;

        let newCurr = newHead; //4
        console.log("newCurr", newCurr.value)
        while (newCurr.next) {
            newCurr = newCurr.next;
        }
        newCurr.next = head;

        this.head = newHead;
    }

    createCycle() {
        let head = this.head;

        let curr = this.head;
        while (curr.next) {
            curr = curr.next;
        }

        curr.next = head;
    }

    detectCycle() {
        if (!this.head) return false;

        let slow = this.head;
        let fast = this.head.next;

        while (fast && fast.next) {
            if (slow === fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    print() {
        let curr = this.head;

        let str = "";
        while (curr) {
            str += `${curr.value} -> `;
            curr = curr.next;
        }

        str = str.substring(0, str.length-3); // to remove last arrow
        console.log("linked list:", str);
    }
}

let linkedList = new LinkedList();
linkedList.add(2);
linkedList.add(3);
linkedList.add(4);
linkedList.add(5);
linkedList.add(6);
linkedList.add(7);
linkedList.add(8);
linkedList.add(9);
linkedList.insertAtIndex(1, 0);
linkedList.removeFromIndex(123);
linkedList.removeElement(20);
linkedList.print();

const indexOfNo = linkedList.indexOf(5);
console.log("indexOfNo", indexOfNo);

const isLLEmpty = linkedList.isEmpty();
console.log("isLLEmpty", isLLEmpty);

// const length = linkedList.length();
// console.log("length", length);

// linkedList.reverse();
// linkedList.print();

// linkedList.printReverse();

// linkedList.rotateLeftBy(3);
// linkedList.print();

// linkedList.createCycle();
// let hasCycle = linkedList.detectCycle();
// console.log("hasCycle", hasCycle);

linkedList.reverseInGroup("ka", 3);
linkedList.print();