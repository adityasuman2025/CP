/*
In Java, by default, it is a min-heap.
Min Heap:
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
Max Heap: Using comparator to make it a max heap.
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

Updated Java code: 
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


/*
    in array representation of a tree
    if parent is at index i
    then its childrens should be at, left child = 2*i+1, right child = 2*i+2
    i.e.
    parent: i
    left child: 2*i+1
    right child: 2*i+2

    if child: i
    parent: Math.ceil(i/2) - 1 
*/


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

