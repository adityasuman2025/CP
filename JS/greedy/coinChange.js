/*
https://leetcode.com/problems/coin-change-ii/description/

518. Coin Change II
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
*/

// recursion, time: exponential O(2^N), space: O(N)
function change(target, arr) {
    let c = 0;
    function dfs(start, sum) {
        if (sum === target) {
            c++;
            return;
        }

        for (let i = start; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                dfs(i, sum + arr[i])
            }
        }
    }
    dfs(0, 0)

    return c;
}

// memoised recursion, time: exponential O(N x T), space: O(N x T)
function change(target, arr) {
    if (target === 0) return 1;

    let memo = {}; // whenever we apply memoization on any function, key is its arguments (not a single argument but all arguments)
    function dfs(start, sum) {
        if (sum === target) return 1;

        let k = 0
        for (let i = start; i < arr.length; i++) {
            let newSum = sum + arr[i];
            let key = newSum + " " + i;
            if (newSum <= target) {
                k += (memo.hasOwnProperty(key)) ? memo[key] : dfs(i, newSum);
            }
        }

        let key = sum + " " + start;
        memo[key] = k;
        return memo[key];
    }
    dfs(0, 0);

    return memo["0 0"];
}
