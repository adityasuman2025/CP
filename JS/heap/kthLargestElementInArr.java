/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75

215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/


/*
    Priority Queue
    In JavaScipt there is no STL (Standard Template Library) for priorty queue, so we need to implment our own, when needed


    In Java, by default, it is a min-heap.
    Min Heap: PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Max Heap: PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); (Using comparator to make it a max heap)
*/


import java.util.*;

class Solution {
    // Time: O(NlogN), Space: O(N)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a); // max heap // top element in max-heap is the largest element

        // adding all array elements in max-heap
        for (int i = 0; i<nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        // removing k-1 element from max-heap, so that the top become kth largest element
        for (int i = 0; i<k-1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek(); // top is the kth largest element
    }


    /*
        The main idea of this solution is to use a min-heap with a maximum size of k. 
        By doing this, we ensure that the smallest of the k largest elements is always on the top of the heap.

        before pushing more elements in the min-heap (of size k), we will check if the coming element is greater than top of the min-heap (smallest element) 
        then we will remove the top element (poll) and add the new element in the min-heap

        because we want Kth largest element, so all elements smaller than that should not exist in the min-heap and Kth largest lie on top
    */
    // Time: O(Nlogk), Space: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) { // if this element is greater than top of the minHeap
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
}

