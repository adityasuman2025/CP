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
    if (n < 0) { // if n is negative then making x as oposite, i.e. fraction
        x = 1 / x;
        n = -n;
    }

    const memo = new Map();

    function util(num, p) {
        if (num === 1 || p === 0) return 1;

        if (memo.has(p)) return memo.get(p);

        if (p % 2 === 0) {
            const half = memo.has(p / 2) ? memo.get(p / 2) : util(num, p / 2);
            memo.set(p / 2, half);
            memo.set(p, half * half);
            return half * half;
        } else {
            if (!memo.has(p - 1)) memo.set(p - 1, util(num, p - 1));
            return num * memo.get(p - 1);
        }
    }

    return util(x, n);
};