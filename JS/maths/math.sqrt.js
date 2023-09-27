/*
https://leetcode.com/problems/sqrtx/description/

69. Sqrt(x)
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
*/

/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    let start = 0, end = x;
    while (start <= end) {
        const mid = parseInt((start + end) / 2);
        const midSqr = mid * mid;

        if (midSqr === x) return mid;
        else if (midSqr > x) {
            end = mid - 1;
        } else { // midSqr < x
            start = mid + 1;
        }
    }
    /*
        start becomes the number next to sqrt of x
        end becomes the number prev to sqrt of x
    */
    return end;
};