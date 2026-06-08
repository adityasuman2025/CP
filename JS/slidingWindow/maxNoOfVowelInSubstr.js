/*
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75

1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
*/
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */

const VOWELS = { a: 1, e: 1, i: 1, o: 1, u: 1 };
var maxVowels = function(s, k) {
    let max = 0;

    let v = 0, start = 0;
    for (let end = 0; end < s.length; end++) {
        const char = s[end];
        if (VOWELS.hasOwnProperty(char)) v++;

        if (end - start + 1 > k) {
            if (VOWELS.hasOwnProperty(s[start])) v--;
            start++;
        }

        max = Math.max(max, v);
    }

    return max;
};