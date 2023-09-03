/*
https://leetcode.com/problems/valid-parentheses/

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


Array.prototype.peek = function() {
    return this[this.length-1];    
}

/**
 * @param {string} s
 * @return {boolean}
*/
var isValid = function(s) {
    let stack = [];
    
    for (let i = 0; i<s.length; i++) {
        let char = s[i];
        if ([ "(", "{", "[" ].includes(char)) {
            stack.push(char);
        } else if(char == ")" && stack.peek() == "(") {
            stack.pop();
        } else if(char == "}" && stack.peek() == "{") {
            stack.pop();
        } else if(char == "]" && stack.peek() == "[") {
            stack.pop();
        } else {
            stack.push(char);
        }
    }
    
    return stack.length == 0;
}