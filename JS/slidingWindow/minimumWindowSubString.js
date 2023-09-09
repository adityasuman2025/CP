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


// it does not work
/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
    if (t.length > s.length) return "";

    let tObj = t.split("").reduce((acc, i) => {
        acc[i] = (acc[i] || 0) + 1;
        return acc;
    }, {});

    let minLen = Number.MAX_SAFE_INTEGER, out = ""
    let windodwIndicesOfT = [], windowChars = new Map();

    let right = 0;
    while (right < s.length) {
        let char = s[right];
        if (tObj.hasOwnProperty(char)) { // O(1)
            if (!windowChars.has(char)) {
                windowChars.set(char, 1);
                windodwIndicesOfT.push(right);
            }
        }

        if (windodwIndicesOfT.length === t.length) { // O(length of indicesOfTWin)
            let thisLen = right - windodwIndicesOfT[0] + 1;
            // console.log("right", right, thisLen);
            // console.log("windodwIndicesOfT", windodwIndicesOfT, windowChars);


            if (thisLen < minLen) {
                minLen = thisLen;
                out = s.substring(right - minLen, right + 1)
            }

            const toRemove = windodwIndicesOfT.shift();
            windowChars.delete(s[toRemove]);

            if (right === s.length - 1) break;
            right = windodwIndicesOfT[0];
        } else {
            right++;
        }
    }


    return out;
};