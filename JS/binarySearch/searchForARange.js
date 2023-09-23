/*
https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/

Search for a Range
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/


var searchRange = function(arr, target) {
    let start = 0, end = arr.length - 1;

    let ans = [];

    let k = -1;
    while (start <= end) {
        let mid = parseInt((start + end) / 2);

        if (arr[mid] === target) {
            k = mid;
            end = mid - 1;
        } else if (target < arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    ans.push(k);


    start = 0, end = arr.length - 1;
    k = -1;
    while (start <= end) {
        let mid = parseInt((start + end) / 2);

        if (arr[mid] === target) {
            k = mid;
            start = mid + 1;
        } else if (target < arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    ans.push(k);


    return ans;
};
