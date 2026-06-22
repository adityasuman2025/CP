/*
    https://leetcode.com/problems/fibonacci-number/description/

    509. Fibonacci Number
*/

/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    const memo = new Map();
    memo.set(0, 0);
    memo.set(1, 1);

    function util(n) {
        if (memo.has(n)) return memo.get(n);

        memo.set(n, util(n - 2) + util(n - 1));
        return memo.get(n);
    }
    return util(n);
};