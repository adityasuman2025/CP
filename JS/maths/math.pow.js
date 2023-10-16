/*
https://leetcode.com/problems/powx-n/description/

50. Pow(x, n)
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/

/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
// time: O(logn), space: O(1)
var myPow = function(x, n) {
    if (n < 0) { // if n is negative then making x as oposite, i.e. fraction
        x = 1 / x;
        n = -n;
    }

    function pow(x, n) {
        if (n === 0) return 1;

        if (n % 2 === 0) { // even
            let halfPow = pow(x, n / 2);
            return halfPow * halfPow;
        } else return x * pow(x, n - 1);
    }

    return pow(x, n);
};

// time: O(logn), space: O(logn)
var myPow = function(x, n) {
    if (n < 0) x = 1 / x;
    n = Math.abs(n);

    let memo = {};
    function util(x, n) {
        if (n < 1) return 1;

        if (n % 2 === 0) { // even
            let temp = memo.hasOwnProperty(n / 2) ? memo[n / 2] : util(x, n / 2);
            memo[n / 2] = temp;

            return temp * temp;
        } else {
            let temp1 = memo.hasOwnProperty(n - 1) ? memo[n - 1] : util(x, n - 1);
            memo[n - 1] = temp1;

            return x * temp1;
        }
    }

    return util(x, n);
};