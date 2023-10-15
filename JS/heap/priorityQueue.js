/*
    Priority Queue
    In JavaScipt there is no STL (Standard Template Library) for priorty queue, so we need to implment our own, when needed


    In Java, by default, it is a min-heap.
    Min Heap: PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Max Heap: PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); (Using comparator to make it a max heap)
*/


class PriorityQueue {
    /**
     * @param {(a: any, b: any) => -1 | 0 | 1} compare - 
     * compare function, similar to parameter of Array.prototype.sort
     */
    constructor(compare) {
        this.data = [];
        this.compare = compare;
    }

    /**
     * return {number} amount of items
     */
    size() {
        return this.data.length;
    }

    /**
     * returns the head element
     */
    peek() {
        return this.data[0];
    }

    /**
     * @param {any} element - new element to add
     */
    add(element) {
        this.data.push(element);

        this.heapifyUp();
    }

    /**
     * remove the head element
     * @return {any} the head element
     */
    poll() {
        let val = this.data[0];

        this.data[0] = this.data[this.data.length - 1];
        this.data.pop();
        this.heapifyDown();

        return val;
    }

    heapifyUp() {
        let arr = this.data;
        let idx = this.data.length - 1;

        while (this.getParentIdx(idx) >= 0 && (this.compare(arr[idx], arr[this.getParentIdx(idx)]) < 0)) {
            this.swap(idx, this.getParentIdx(idx));
            idx = this.getParentIdx(idx);
        }
    }

    heapifyDown() {
        let n = this.data.length, arr = this.data;
        let idx = 0;

        while (this.getLeftChildIdx(idx) < n || this.getRightChildIdx(idx) < n) {
            let smallerEle = arr[this.getLeftChildIdx(idx)], smallerEleIdx = this.getLeftChildIdx(idx);

            if (this.getRightChildIdx(idx) < n && (this.compare(arr[this.getRightChildIdx(idx)], smallerEle) < 0)) {
                smallerEle = arr[this.getRightChildIdx(idx)];
                smallerEleIdx = this.getRightChildIdx(idx);
            }

            if (this.compare(smallerEle, arr[idx]) < 0) {
                this.swap(idx, smallerEleIdx);
                idx = smallerEleIdx;
            } else {
                break;
            }
        }
    }


    getParentIdx(i) {
        return parseInt((i - 1) / 2);
    }

    getLeftChildIdx(i) {
        return 2 * i + 1;
    }

    getRightChildIdx(i) {
        return 2 * i + 2;
    }

    swap(i, j) {
        let temp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }
}


const minHeap = new PriorityQueue((a, b) => a - b)
minHeap.add(5)
minHeap.add(3)
minHeap.add(1)
minHeap.add(4)
minHeap.add(2)
const result1 = []
while (minHeap.size() > 0) {
    result1.push(minHeap.poll())
}
console.log("result1", result1);


const maxHeap = new PriorityQueue((a, b) => b - a)
maxHeap.add(5)
maxHeap.add(3)
maxHeap.add(1)
maxHeap.add(4)
maxHeap.add(2)
const result2 = []
while (maxHeap.size() > 0) {
    result2.push(maxHeap.poll())
}
console.log("result2", result2);