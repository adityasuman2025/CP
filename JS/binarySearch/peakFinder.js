/*
https://leetcode.com/problems/find-peak-element/

162. Find Peak Element
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
*/


var findPeakElement = function(arr) {
    let start = 0, end = arr.length - 1;

    while (start <= end) {
        let mid = parseInt((start + end) / 2);

        if (arr[mid + 1] > arr[mid]) { // if something greater is found at mid+1 then looking towards right i.e. start = mid + 1;
            start = mid + 1;
        } else if (arr[mid - 1] > arr[mid]) { // if something greater is found at mid-1 then looking towards left i.e. end = mid - 1;
            end = mid - 1;
        } else { // else this element (mid) is greater than its left (mid-1) and right (mid+1) element
            return mid;
        }
    }

    return -1;
};