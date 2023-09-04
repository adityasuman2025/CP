/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock

121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

/**
 * @param {number[]} prices
 * @return {number}
*/
var maxProfit = function(prices) {
    //we can buy and sell only once, 
    //and sell only after buying
    //so moving from behind of the array, to search max sell price, we can have at a element position
    let maxPrice = prices[prices.length-1];
    let maxProfit = 0;
    
    for (let i = prices.length - 2; i>=0; i--) {
        maxPrice = Math.max(maxPrice, prices[i]);
        
        maxProfit = Math.max(maxProfit, maxPrice -  prices[i]);
    }
    
    return maxProfit;
};

//or
// var maxProfit = function(arr) {
//     let minPrice = arr[0];
//     let maxProfit = 0;
    
//     for (let i = 1; i<arr.length; i++) {
//         minPrice = Math.min(minPrice, arr[i]);
//         maxProfit = Math.max(maxProfit, arr[i] - minPrice);
//     }
    
//     return maxProfit;
// };