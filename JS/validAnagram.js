/*
https://leetcode.com/problems/valid-anagram/

242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;

    const map = new Map();
    for (let i = 0; i < s.length; i++) {
        const char = s[i];
        map.set(char, (map.get(char) || 0) + 1);
    }

    for (let i = 0; i < t.length; i++) {
        const char = t[i];
        const c = map.get(char);

        if (!c) return false;

        if (c === 1) map.delete(char)
        else map.set(char, c - 1);
    }

    return map.size === 0;
};