/*
https://leetcode.com/problems/find-the-duplicate-number/

287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.


Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
*/


// time: O(n), space: O(1)
/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    let slow = nums[0]
    let fast = nums[0]

    while (true) {
        slow = nums[slow]
        fast = nums[nums[fast]]
        if (slow == fast) break
    }

    //Now, once we detect the cycle, now its time to find the starting point of it. Just like in a linked list, we will reset our slow pointer to again point to first element
    slow = nums[0]

    //And now, we increment both pointers one step at a time until they point to the same element
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[fast]
    }

    return slow;
};


// we gonna use, element's value as the index, to mark them visited, and we are makring them visited by making them negative, if we visit any negative item agaib, means its already been visited
// time: O(n), space: O(1)
var findDuplicate = function(arr) {
    for (let i = 0; i < arr.length; i++) {
        let item = arr[i];
        let comingItemIdx = Math.abs(item);

        if (arr[comingItemIdx] < 0) return comingItemIdx; // if the item at comingItemIdx is negative, that means that item is already been visited, so it must bt duplicate so returning comingItemIdx

        arr[comingItemIdx] = -arr[comingItemIdx]; // marking element at index as item, visited
    }
};