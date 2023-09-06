/*
https://leetcode.com/problems/longest-common-subsequence/

1143. Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/


/**
 * @param {string} text1 // a
 * @param {string} text2 // b
 * @return {number}
 */
var longestCommonSubsequence = function (a, b) {
    let M = a.length, N = b.length;

    let dp = new Array(M + 1).fill(0).reduce((acc, i, idx) => {
        acc[idx] = new Array(N + 1).fill(0)
        return acc;
    }, []); // making a 2D array of MxN

    for (let i = 0; i <= M; i++) {
        for (let j = 0; j <= N; j++) {
            if (i == 0 || j == 0) dp[i][j] = 0;
            else if (a.charAt(i - 1) === b.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    return dp[M][N];
};