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