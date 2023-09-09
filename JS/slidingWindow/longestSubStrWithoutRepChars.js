/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

 
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

//SLIDING WINDOW TECHNIQUE

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    let maxLen = 0;

    let window = new Map(), start = 0;
    for (let i = 0; i < s.length; i++) {
        let char = s.charAt(i);

        while (window.has(char)) {
            let len = i - start;
            maxLen = Math.max(maxLen, len);
            window.delete(s.charAt(start));
            start++;
        }

        window.set(char, 1);
    }
    maxLen = Math.max(maxLen, window.size);

    return maxLen;
};


/*
    we are using Map here instead of Array, Set, {}, because

    MAP: map = new Map()
    Insertion (map.set(key, val)):
        Average Case: O(1)
        Worst Case: O(log n)
    Deletion (map.delete(key)):
        Average Case: O(1)
        Worst Case: O(log n)
    Access (map.get(key)):
        Average Case: O(1)
        Worst Case: O(log n)
    Search (map.has(key)):
        Average Case: O(1)
        Worst Case: O(n)
    Iteration (map.keys(), map.values(), map.entries()):
        O(n)
    Size (map.size):
        O(1)


    OBJECT: obj = {}
    Isertion (obj[key] = val):
        Average Case: O(1)
        Worst Case: O(n)
    Deletion (delete obj[key]):
        Average Case: O(1)
        Worst Case: O(n)
    Access (obj[key]):
        Average Case: O(1)
        Worst Case: O(n)
    Search (obj.hasOwnProperty(key)):
        Average Case: O(1)
        Worst Case: O(n)
    Iteration (Object.keys(obj), Object.values(obj), Object.entries(obj)):
        O(n)
    Size (Object.keys(obj).length, Object.values(obj).length, Object.entries(obj).length):
        O(n)


    SET: set = new Set()
    Insertion (set.add(val)):
        Average Case: O(1)
        Worst Case: O(n)
    Deletion (set.delete(val)):
        Average Case: O(1)
        Worst Case: O(n)
    Access (set.has(val)):
        Average Case: O(1)
        Worst Case: O(n)
    Search (set.has(val)):
        Average Case: O(1)
        Worst Case: O(n)
    Iteration (set.values()):
        O(n)
    Size (set.size):
        O(1)


    ARRAY: arr = []
    Insertion (arr.push(val), arr.unshift(val)):
        At the end (push): O(1)
        At the Beginning (unshift): O(n)
    Deletion (arr.pop(), arr.shift()):
        At the end (pop): O(1)
        At the Beginning (shift): O(n)
    Access (arr[idx]):
        Time Complexity: O(1)
    Search (arr.indexOf(val), arr.includes(val)):
        O(n)
    Iteration (arr.forEach()):
        O(n)
    Size (arr.length):
        O(1)
*/