/*
https://leetcode.com/problems/permutation-in-string

567. Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 
Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
*/


//O(n*26)
var checkInclusion = function(s1, s2) {
    let s1Length = s1.length;
    
    let s1CharsMap = Array(26).fill(0);
    for (let i = 0; i < s1Length; i++) {
        let char = (s1[i]).charCodeAt(0);
        s1CharsMap[char - 97] += 1;
    }
    console.log("s1CharsMap", s1CharsMap)
    
    for (let i = 0; i < s2.length; i++) {
        let char = (s2[i]).charCodeAt(0);
        if (s1CharsMap[char - 97]) {
            let tempCharsMap = Array(26).fill(0);
            for (let j = i; j < i + s1Length && j < s2.length; j++) {
                
                let temp = (s2[j]).charCodeAt(0);
                tempCharsMap[temp - 97] += 1;
            }
            
            console.log("tempCharsMap", tempCharsMap)
            if (JSON.stringify(s1CharsMap) === JSON.stringify(tempCharsMap)) return true;
        }
    }
    
    return false;
};