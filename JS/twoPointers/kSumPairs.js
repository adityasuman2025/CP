/*
https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

1679. Max Number of K-Sum Pairs
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
*/


// two pointers
// time complexity: O(nlong), space complexity: 0(1)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxOperations = function (nums, k) {
    nums.sort((a, b) => a - b);

    let c = 0;
    let start = 0, end = nums.length - 1;
    while (start < end) {
        let sum = nums[start] + nums[end];
        if (sum === k) {
            c++;
            start++;
            end--;
        } else if (sum > k) {
            end--;
        } else {
            start++;
        }
    }

    return c;
};


// hashmap
// time complexity: O(n), space complexity: 0(n)
var maxOperations = function (nums, k) {
    let map = {}

    let c = 0;
    for (let i = 0; i < nums.length; i++) {
        let diff = k - nums[i];

        if (map.hasOwnProperty(diff)) {
            if (map[diff] === 1) delete map[diff]
            else map[diff] = map[diff] - 1;
            c++;
        } else {
            map[nums[i]] = map[nums[i]] ? map[nums[i]] + 1 : 1;
        }
    }

    return c;
};
