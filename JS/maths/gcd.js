/*
    https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/

    1979. Find Greatest Common Divisor of Array
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findGCD = function(nums) {
    let max = -Infinity, min = Infinity;
    for (let i = 0; i < nums.length; i++) {
        const item = nums[i]
        if (item > max) max = item;
        if (item < min) min = item;
    }

    return gcd(max, min);
};

function gcd(a, b) {
    if (b === 0) return a;

    return gcd(b, a % b);
}