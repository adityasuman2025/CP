class Stack {
    constructor() {
        this.items = [];
    }

    push(val) {
        this.items.push(val);
    }

    pop() {
        if (this.items.length < 1) return "Underflow";

        let ele = this.items[this.items.length - 1];
        this.items = this.items.slice(0, this.items.length - 1);
        return ele;
    }

    peek() {
        if (this.items.length < 1) return "Underflow";

        return this.items[this.items.length - 1]
    }

    isEmpty() {
        return this.items.length === 0;
    }

    length() {
        return this.items.length;
    }

    search(toSearch) {
        this.items.search;

        for (let i = 0; i < this.items.length; i++) {
            if (this.items[i] === toSearch) return true;
        }
        return false;
    }

    print() {
        let str = this.items.reduce((acc, i, idx) => (acc + (idx === 0 ? "" : ", ") + i), "")

        console.log("printStack:", str);
    }
}

const stack = new Stack();
stack.push(0);
stack.push(1);
stack.push(2);
stack.push(3);
stack.pop();
const peek = stack.peek();
console.log("peek", peek)

const isEmp = stack.isEmpty();
console.log("isEmp", isEmp)

const len = stack.length();
console.log("len", len)

const isFound = stack.search(2);
console.log("isFound", isFound)

stack.print();