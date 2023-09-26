/*
https://leetcode.com/problems/coin-change/

322. Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
*/

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
function coinChange(coins, amount) {
    // Initialize an array to store the minimum number of coins needed for each amount from 0 to amount
    const dp = new Array(amount + 1).fill(Infinity);

    dp[0] = 0; // Base case: 0 coins needed for 0 amount

    for (let thisAmount = 1; thisAmount <= amount; thisAmount++) { // we will try to make 1 to amount using the given coins and store in dp[thisAmount]
        for (let coin of coins) {
            if (coin <= thisAmount) { // if the current coin is less than amount only then we can use that coin
                dp[thisAmount] = Math.min(dp[thisAmount], dp[thisAmount - coin] + 1); // min of, if we pick that coin or not pick that coin // if we pick then we can use the dp of thisAmount - coin
            }
        }
    }

    return dp[amount] === Infinity ? -1 : dp[amount];
}
