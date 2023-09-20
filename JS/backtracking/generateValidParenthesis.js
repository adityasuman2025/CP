/*
https://leetcode.com/problems/generate-parentheses/description/

22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/


/**
 * @param {number} n
 * @return {string[]}
*/

// time: O(n)
var generateParenthesis = function(n) {
    let ans = [];
    function comb(openIdx, closeIdx, str) {
        if (str.length === 2 * n) {
            ans.push(str);
            return;
        }

        if (openIdx < n) comb(openIdx + 1, closeIdx, str + "(");
        if (closeIdx < openIdx) comb(openIdx, closeIdx + 1, str + ")"); // in a valid/balanced parenthesis at any point, count of close brackets must be less than count of open brackets
    }
    comb(0, 0, "");

    return ans;
};