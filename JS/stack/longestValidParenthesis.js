/*
https://leetcode.com/problems/longest-valid-parentheses/

32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.


Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
*/


/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    let stack = [], l = 0
    stack.push(-1)
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') stack.push(i)
        else {
            stack.pop()
            if (stack.length === 0) stack.push(i)
            else {
                l = Math.max(l, i - stack.at(-1)) //stack.at(-1) is stack.peek()
            }
        }
    }
    
    return l
};