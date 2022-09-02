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

var isAnagram = function(str1, str2) {
    let map = {};
    for (let i = 0; i<str1.length; i++) {
        let char = str1[i];
        map[char] = map[char] ? map[char] + 1 : 1;
    }
    
    for (let i = 0; i<str2.length; i++) {
        let char = str2[i];
        
        if (map[char] > 1) {
            map[char] = map[char] - 1;
        } else if (map[char] == 1) {
            delete map[char];
        } else {
             map[char] = map[char] ? map[char] + 1 : 1;
        }
    }
    
    return Object.keys(map).length == 0
};