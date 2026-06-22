/*
https://leetcode.com/problems/excel-sheet-column-number/description/

171. Excel Sheet Column Number
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
*/

/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    const len = columnTitle.length - 1;

    let out = 0;
    for (let idx = 0; idx <= len; idx++) {
        const char = columnTitle[idx];
        const code = char.charCodeAt(0) - 65 + 1;
        out = out + (code * Math.pow(26, len - idx))
    };

    return out;
};