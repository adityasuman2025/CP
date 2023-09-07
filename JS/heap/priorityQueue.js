/*
    Priority Queue
    In JavaScipt there is no STL (Standard Template Library) for priorty queue, so we need to implment our own, when needed


    In Java, by default, it is a min-heap.
    Min Heap: PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Max Heap: PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); (Using comparator to make it a max heap)

    
    private static int findKthSmallestElement(int[] arr, int k, int size) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < size; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
*/

