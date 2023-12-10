class Queue {
    constructor() {
        this.items = [];
    }

    enqueue(val) {
        this.items.push(val);
    }

    dequeue() {
        if (this.items.length < 1) return "Underflow";

        const ele = this.items[0];
        this.items = this.items.slice(1);
        return ele;
    }

    front() {
        if (this.items.length < 1) return "Underflow";

        return this.items[0];
    }

    isEmpty() {
        return this.items.length === 0;
    }

    print() {
        let str = this.items.reduce((acc, i, idx) => (acc + (idx === 0 ? "" : ", ") + i), "")

        console.log("printQueue:", str);
    }
}

const q = new Queue();
q.enqueue(0);
q.enqueue(1);
q.enqueue(2);
q.enqueue(3);
q.dequeue()
const fro = q.front();
console.log("fro", fro);

q.print()