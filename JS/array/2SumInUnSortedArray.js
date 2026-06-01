/*
https://leetcode.com/problems/two-sum/description/

1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// time: O(n); space: O(n)
var twoSum = function(arr, target) {
    let map = new Map();
    for (let i = 0; i < arr.length; i++) {
        let req = target - arr[i];

        if (map.has(req)) return [i, map.get(req)]
        else map.set(arr[i], i);
    }
};

// time: O(nlogn); space: O(n)
var twoSum = function(arr, target) {
    const obj = {};
    arr.forEach((item, idx) => obj[item] = obj[item] ? [...obj[item], idx] : [idx]);

    arr.sort((a, b) => a - b);

    let start = 0, end = arr.length - 1;
    while (start < end) {
        if (arr[start] + arr[end] === target) {
            if (obj[arr[start]].length > 1) return obj[arr[start]];
            else if (obj[arr[end]].length > 1) return obj[arr[end]];
            else return [obj[arr[start]][0], obj[arr[end]][0]];
        } else if (arr[start] + arr[end] > target) end--;
        else start++;
    }
};