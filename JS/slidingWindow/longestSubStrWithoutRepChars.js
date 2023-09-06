/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

 
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

//SLIDING WINDOW TECHNIQUE

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let maxLen = 0;
    
    let window = [];
    for (let i=0; i<s.length; i++) {
        let char = s[i];
        
        while (window.includes(char) && window.length>0) window.shift();
        window.push(char);

        maxLen = Math.max(maxLen, window.length);
    }
    
    return maxLen;
};