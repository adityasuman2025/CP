/*
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(arr) {
    let min = arr[0];

    let start = 0, end = arr.length - 1;
    while (start <= end) {
        const mid = Math.floor((start + end) / 2);

        if (arr[start] <= arr[end]) {
            min = Math.min(min, arr[start]);
            break;
        }

        if (arr[start] <= arr[mid]) {
            // left part is sorted
            min = Math.min(min, arr[start]);
            start = mid + 1;
        } else {
            // right part is sorted
            min = Math.min(min, arr[mid]);
            end = mid - 1
        }
    }

    return min;
};