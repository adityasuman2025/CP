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
    const len = columnTitle.length;
    const asciiOfA = 65;

    let sum = 0
    let indexFromBack = 1;
    for (let i = len - 1; i >= 0; i--) { // piche se process krne hai
        let charAscii = columnTitle[i].charCodeAt(0);

        sum += indexFromBack * (charAscii - asciiOfA + 1);
        indexFromBack = indexFromBack * 26;
    }

    return sum;
};