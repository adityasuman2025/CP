/*
    Heap 
    Heap is a Complete Binary Tree
    1. Max Heap: It keeps track of largest element (max heap is used if asked for Kth smallest element)
                Root Node should be greater than all left and right sub-tree nodes and recursively true for all its sub-trees
    2. Min Heap: It keeps track of smallest element (min heap is used if asked for Kth largest element)
                Root Node should be smaller than all left and right sub-tree nodes and recursively true for all its sub-trees
    
    Priority Queue: Priority Sueue is implementation of Min-Heap in Java) -> min heap is a binary tree in which root node(parent node) is always less then its children nodes
    Heapify: The process of re-arranging the heap by comparing each parent with its children recursively is k/n as heapify.
            We can heapify index i, only if all the elements in both its left and right sub-trees are following heap property.
*/

/*
    in array representation of a tree
    if parent is at index i
    then its childrens should be at, left child = 2*i+1, right child = 2*i+2
    i.e.
    parent: i
    left child: 2*i+1
    right child: 2*i+2

    if child: i
    parent: Math.ceil(i/2) - 1 or parseInt((index - 1) / 2) or Math.floor((index - 1) / 2)
*/


class MinHeap {
    constructor() {
        this.heap = [];
    }

    peek() {
        if (this.heap.length === 0) return null;

        return this.heap[0];
    }

    insert(val) {
        this.heap.push(val); // inserting new element at the bottom/leaf of the tree (end of the array)

        // after inserting the val at the end, the heap may not follow the min heap property, so need to heapify it
        // doing Heapify Up because element is inserted at the bottom (end of the array) so need to shift this last element at its correct position,
        // which may be up in the heap (as there is nothing below this element in the heap)
        this.heapifyUp();
    }

    // remove function in Min-Heap will always return the smallest element present in the heap
    // as Min Heap tracks smallest element and smallest element always lie at the top (root) of the heap
    remove() {
        if (this.heap.length === 0) return null;

        let val = this.heap[0]; // storing the smallest element in a varaible

        this.heap[0] = this.heap[this.heap.length - 1]; // putting the last element of the heap at the root
        this.heap.pop(); // deleteing the last element

        // after removing the 1st element and putting the last element at the top of the heap
        // heap may not follow Min-Heap property, so need to heapify it
        // doing Heapify Down because the last element of the heap is put at the top, so need to shift this element at correct position
        // which may be down in the heap (as there is nothing above this element in the heap)
        this.heapifyDown();

        return val;
    }

    heapifyUp() {
        let index = this.heap.length - 1; // we have to start from last element
        let parentIndex = this.getParentIndex(index); // getting parent index of the last element

        // we will pushing that (last) element above, till it has parent and its value is less than its parent (as it is a Min-Heap)
        while (parentIndex >= 0 && this.heap[index] < this.heap[parentIndex]) {
            this.swap(index, parentIndex);
            index = parentIndex; // now our element is present at parentIndex as we swapped it in the above line
            parentIndex = this.getParentIndex(index);
        }
    }

    heapifyDown() {
        let len = this.heap.length;
        let index = 0; // we have to start from first (top) element

        // we will keep pushing that (first) element below, till its has children
        while ((this.getLeftChildIndex(index) < len) || (this.getRightChildIndex(index) < len)) {
            // we are trying to find the children which is smallest, left or right
            let smallerChildIndex = this.getLeftChildIndex(index); // assuming the left child is smaller

            // checking if right child exist and is smaller than left child, if yes then making smallerChildIndex = right child index
            if (
                (this.getRightChildIndex(index) < len) &&
                (this.heap[this.getRightChildIndex(index)] < this.heap[smallerChildIndex])
            ) {
                smallerChildIndex = this.getRightChildIndex(index);
            }

            // if our (first) element smaller than its children i.e smallerChildIndex then we don't need to push it below any more
            if (this.heap[index] < this.heap[smallerChildIndex]) break;
            else {
                this.swap(index, smallerChildIndex);
                index = smallerChildIndex; // now our element is present at smallerChildIndex as we swapped it in the above line
            }
        }
    }

    print() {
        var heap = "";
        for (let i = 0; i < this.heap.length; i++) heap += `${this.heap[i]} `;
        console.log("print:", heap);
    }

    // helper functions
    getLeftChildIndex(index) {
        return 2 * index + 1;
    }

    getRightChildIndex(index) {
        return 2 * index + 2;
    }

    getParentIndex(index) {
        return parseInt((index - 1) / 2);
    }

    swap(i, j) {
        const temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
}


// Creating the Heap
const heap = new MinHeap();

// Adding The Elements
heap.insert(15);
heap.insert(30);
heap.insert(40);
heap.insert(10);
heap.insert(50);
heap.insert(100);
heap.insert(5);

// Printing the Heap
heap.print();

// Peeking And Removing Top Element
console.log(heap.peek());
console.log(heap.remove()); // 5
console.log(heap.remove()); // 10

// Printing the Heap After Deletion
heap.print();