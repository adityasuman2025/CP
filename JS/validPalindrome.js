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

var isPalindrome = function (s) {
    let start = 0, end = s.length - 1;
    while (start < end) {
        let startChar = s.charAt(start), endChar = s.charAt(end);

        if (!isAlphaNumeric(startChar)) start++;
        else if (!isAlphaNumeric(endChar)) end--;
        else {
            // if both of them are aplha numeric
            if (startChar.toLowerCase() !== endChar.toLowerCase()) return false;

            start++;
            end--;
        }
    }

    return true;
};

function isAlphaNumeric(char) {
    let ascii = char.charCodeAt(0);

    if (
        (ascii >= 97 && ascii <= 122) ||
        (ascii >= 65 && ascii <= 90) ||
        (ascii >= 48 && ascii <= 57)
    ) return true;

    return false;
}