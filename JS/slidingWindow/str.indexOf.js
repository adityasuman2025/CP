/*
https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/885/

Implement strStr()
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
*/


// time: O(MxN)
var strStr = function (haystack, needle) {
    let len = needle.length;

    for (let i = 0; i < haystack.length; i++) {
        if (haystack.charAt(i) == needle.charAt(0)) {
            let j = 1;
            for (; j < len && j < haystack.length; j++) {
                if (haystack.charAt(i + j) !== needle.charAt(j)) break;
            }

            if (j === len) return i;
        }
    }

    return -1;
};


// time: O(M+N)
var strStr = function (haystack, needle) {
    let len = needle.length;

    let winLen = 0;
    for (let i = 0; i < haystack.length; i++) {
        if (haystack.charAt(i) === needle.charAt(winLen)) {
            winLen++;

            if (winLen === len) return i - winLen + 1;
        } else {
            i = i - winLen;
            winLen = 0;
        }
    }

    return -1;
};