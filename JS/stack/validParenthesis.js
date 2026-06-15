/*
https://leetcode.com/problems/valid-parentheses/description/

20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
*/

/**
 * @param {string} s
 * @return {boolean}
 */
const CLOSED = ")}]";
var isValid = function(str) {
    let stack = [];
    for (let i = 0; i < str.length; i++) {
        const char = str[i];

        if (CLOSED.includes(char)) {
            if (stack.at(-1) === "(" && char === ")") stack.pop();
            else if (stack.at(-1) === "{" && char === "}") stack.pop();
            else if (stack.at(-1) === "[" && char === "]") stack.pop();
            else return false;
        } else stack.push(char);
    }

    return stack.length === 0;
};