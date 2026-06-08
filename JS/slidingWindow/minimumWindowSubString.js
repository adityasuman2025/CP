/*
https://leetcode.com/problems/minimum-window-substring/description/

76. Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/


/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if (t.length > s.length) return "";

    // frequency of chars in t
    let tObj = t.split("").reduce((acc, i) => {
        acc[i] = (acc[i] || 0) + 1;
        return acc;
    }, {});

    let minLen = Number.MAX_SAFE_INTEGER, out = "";
    let windodwIndicesOfT = [];
    let windowChars = {}; // map of char -> frequency in current window

    let required = Object.keys(tObj).length;
    let formed = 0;

    let right = 0;
    while (right < s.length) {
        let char = s[right];

        // If the character is in t
        if (tObj.hasOwnProperty(char)) {
            windowChars[char] = (windowChars[char] || 0) + 1;
            windodwIndicesOfT.push(right);

            if (windowChars[char] === tObj[char]) {
                formed++;
            }
        }

        // When the window is valid, shrink it from the left
        while (formed === required) {
            let leftIndex = windodwIndicesOfT[0];
            let thisLen = right - leftIndex + 1;

            if (thisLen < minLen) {
                minLen = thisLen;
                out = s.substring(leftIndex, right + 1);
            }

            // Pop the leftmost index and update counts
            const toRemove = windodwIndicesOfT.shift();
            const removeChar = s[toRemove];
            windowChars[removeChar]--;

            if (windowChars[removeChar] < tObj[removeChar]) {
                formed--;
            }
        }

        right++;
    }

    return out;
};