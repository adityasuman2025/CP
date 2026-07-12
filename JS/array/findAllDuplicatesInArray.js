/*
    https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
*/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(arr) {
    const ans = [];

    for (let i = 0; i < arr.length; i++) {
        const val = Math.abs(arr[i]);
        const idx = val - 1;

        if (arr[idx] < 0) ans.push(val)
        else arr[idx] = -arr[idx];
    }

    return ans;
};
