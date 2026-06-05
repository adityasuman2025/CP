/*
https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75

345. Reverse Vowels of a String
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"

*/

/**
 * @param {string} s
 * @return {string}
 */

const v = "aeiouAEIOU";

var reverseVowels = function(s) {
    const arr = s.split("");

    let start = 0, end = arr.length;
    while (start < end) {
        if (v.includes(arr[start]) && v.includes(arr[end])) {
            const temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        } else if (v.includes(arr[start])) end--;
        else if (v.includes(arr[end])) start++;
        else {
            start++;
            end--;
        }
    }

    return arr.join("");
};