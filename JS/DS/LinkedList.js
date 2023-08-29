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

    print = function () {
        let curr = this.head, str = "";
        while (curr) {
            str += (curr.val + " -> ")
            curr = curr.next;
        }

        str = str.substring(0, str.length - 3);
        console.log("print:", str)
    }

    add(val) {
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

    remove = function (val) {
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

    removeFromIndex(index) {
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

    printReverse(node) {
        if (node === null) return;

        if (node === undefined) {
            this.printReverse(this.head);
        } else {
            this.printReverse(node.next);
            console.log(node.value);
        }
    }

    rotateLeftBy(k) {
        if ([undefined, null].includes(k) || this.head === null) return;

        k = k % this.length();
        if (k === 0) return; // no rotation required

        let oldHead = this.head;
        let curr = this.head, prev = null, c = 0;
        while (c < k && curr) { // go to the element at k index (curr), it will become the new head
            prev = curr;
            curr = curr.next;
            c++;
        }
        this.head = curr;
        prev.next = null; // breaking bond of prev with the new head

        while (curr.next) curr = curr.next; // will go to the end of the linked list // curr become the last element of the linked list
        curr.next = oldHead; // and attach the old head with the last element of the linkedlist
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
        while (i < k && curr) {
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
linkedList.remove(20);
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