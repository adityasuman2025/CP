function heapSort(arr) {
    let len = arr.length;

    buildHeap();

    for (let i = len - 1; i > 0; i--) {
        // at top/front of the max-heap, largest element is present // we will keep moving largest element at end 
        swap(0, i);

        // after swapping largest element (element at index 0) with element at index i, heap may not follow max-heap property
        // so heapifying it
        heapify(0, i);
    }


    // for max-heap
    function buildHeap() {
        /*
            ref: https://www.youtube.com/watch?v=VkKmmwzfIG4&list=PLEJXowNB4kPyP2PdMhOUlTY6GrRIITx28&index=5

            (For a complete binary tree)
            In a Heap of size N, represented in an array
            Range of internal nodes: 0 to Math.ceil(N/2) - 1
            Range of leaves: Math.ceil(N/2) to N-1

            leaves of a heap always follow min/max heap property (as it has no children)
            so for building a heap we only need to heapify internal nodes, not leaves
        */

        for (let i = Math.floor(len / 2) - 1; i >= 0; i--) {
            heapify(i, len);
        }
    }


    // for max-heap
    function heapify(index, len) {
        let leftChildIndex = (2 * index) + 1, rightChildIndex = (2 * index) + 2;
        while ((leftChildIndex < len) || (rightChildIndex < len)) {
            let greaterChildIndex = leftChildIndex; //left child
            if ((rightChildIndex < len) && arr[rightChildIndex] > arr[greaterChildIndex]) {
                greaterChildIndex = rightChildIndex;
            }

            if (arr[index] > arr[greaterChildIndex]) break;
            else {
                swap(index, greaterChildIndex);

                index = greaterChildIndex;
                leftChildIndex = (2 * index) + 1;
                rightChildIndex = (2 * index) + 2;
            }
        }
    }

    function swap(i, j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


let arr = [12, 11, 13, 5, 6, 7];
heapSort(arr)
console.log("sorted arr", arr);

