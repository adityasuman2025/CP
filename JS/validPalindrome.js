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

/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let start = 0, end = s.length - 1;
    while (start < end) {
        while (start < end && !isAlphaNumeric(s[start])) start++;
        while (start < end && !isAlphaNumeric(s[end])) end--;

        if (start < end && s[start].toLowerCase() !== s[end].toLowerCase()) return false;

        start++;
        end--;
    }

    function isAlphaNumeric(char) {
        const code = char.charCodeAt(0);

        if (
            (code >= 65 && code <= 90) ||
            (code >= 97 && code <= 122) ||
            (code >= 48 && code <= 57)
        ) return true;

        return false;
    }

    return true;
};