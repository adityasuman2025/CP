/*
https://leetcode.com/problems/valid-palindrome/

Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

var isPalindrome = function(str) {
    str = str.toLowerCase();
 
    let cleanedStr = "";
    for (let i = 0; i<str.length; i++) {
        let char = str[i];
        
        if (char.match(/[a-z0-9]/i)) cleanedStr += char;
    }
    
    let start = 0, end = cleanedStr.length-1;
    while (start < end) {
        if (cleanedStr[start] != cleanedStr[end]) return false;
        start++; end--;
    }
    
    return true;
};