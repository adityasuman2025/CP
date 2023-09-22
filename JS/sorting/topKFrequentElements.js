/*
https://leetcode.com/problems/top-k-frequent-elements/description/

347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
*/


// O(nlogn)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    let map = {};

    nums.forEach(num => {
        if (map.hasOwnProperty(num)) map[num] = map[num] + 1
        else map[num] = 1;
    });

    const arr = Object.entries(map).sort((a, b) => b[1] - a[1]); // Object.enteries return object as array, [[key, value]...];

    let ans = [];
    for (let i = 0; i < k; i++) {
        ans.push(arr[i][0]);
    }

    return ans;
};


// O(n) + O(k^2)
var topKFrequent = function(nums, k) {
    let map = {};

    nums.forEach(num => {
        if (map.hasOwnProperty(num)) map[num] = map[num] + 1
        else map[num] = 1;
    });

    let freqArr = [];
    Object.keys(map).forEach((key) => {
        const freq = map[key];

        freqArr[freq] = (freqArr[freq] || []).concat(key);
    });

    let ans = [];
    for (let i = freqArr.length - 1; i >= 0; i--) {
        if (freqArr[i]) ans.push(...freqArr[i]);

        if (ans.length === k) return ans;
    }

    return ans;
};