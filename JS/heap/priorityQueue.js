/*
    Priority Queue
    In JavaScipt there is no STL (Standard Template Library) for priorty queue, so we need to implment our own, when needed


    In Java, by default, it is a min-heap.
    Min Heap: PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Max Heap: PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); (Using comparator to make it a max heap)
*/


class QElement {
    constructor(val, priority) {
        this.val = val;
        this.priority = priority;
    }
}

class PriorityQueue {
    constructor() {
        this.items = [];
    }

    enqueue(val, priority) {
        let newItem = new QElement(val, priority);
        let hasBeenAdded = false;

        // iterating through the entire item array to add element at the correct location of the Queue
        for (let i = 0; i < this.items.length; i++) {
            if (this.items[i].priority > priority) {
                // Once the correct location is found newItem is put there
                this.items.splice(i, 0, newItem); // splice is used to insert new item at any specific index in array // ref: https://www.freecodecamp.org/news/insert-into-javascript-array-at-specific-index/

                hasBeenAdded = true;
                break;
            }
        }

        // if the element have the highest priority, then it is added/pushed at the end of the queue
        if (!hasBeenAdded) this.items.push(newItem);
    }

    dequeue() {
        if (this.items.length === 0) return null;

        return this.items.shift(); // removing and returning the first element of the priority queue
    }

    front() {
        if (this.items.length === 0) return null;

        return this.items[0];
    }

    rear() {
        if (this.items.length === 0) return null;

        return this.items[this.items.length - 1];
    }

    isEmpty() {
        return this.items.length === 0;
    }

    print() {
        let res = "";
        for (let i = 0; i < this.items.length; i++) {
            res += (this.items[i].val + " ")
        }

        console.log("print:", res);
    }
}

// creating object for queue class
var priorityQueue = new PriorityQueue();

// testing isEmpty and front on an empty queue
// return true
console.log(priorityQueue.isEmpty());

// returns "No items in Queue"
console.log(priorityQueue.front());

// adding items to the queue
priorityQueue.enqueue("Sumit", 2);
priorityQueue.enqueue("Gourav", 1);
priorityQueue.enqueue("Piyush", 1);
priorityQueue.enqueue("Sunny", 2);
priorityQueue.enqueue("Sheru", 3);

// prints [Gourav Piyush Sumit Sunny Sheru]
priorityQueue.print();

// prints Gourav
console.log(priorityQueue.front().val);

// prints Sheru
console.log(priorityQueue.rear().val);

// removes Gouurav
console.log(priorityQueue.dequeue().val);

// priorityQueue contains
// [Piyush Sumit Sunny Sheru]
priorityQueue.print();

// Adding another element to the queue
priorityQueue.enqueue("Sunil", 2);

// prints [Piyush Sumit Sunny Sunil Sheru]
priorityQueue.print();