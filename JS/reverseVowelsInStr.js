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
var reverseVowels = function (s) {
    let arr = s.split("");
    let left = 0, right = s.length - 1;

    const vowels = ["a", "e", "i", "o", "u"];

    while (left < right) {
        let leftChar = arr[left].toLowerCase();
        let rightChar = arr[right].toLowerCase();

        if (vowels.includes(leftChar) && vowels.includes(rightChar)) {
            //swap
            let temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            right--;
            left++;
        } else if (vowels.includes(leftChar) && !vowels.includes(rightChar)) {
            right--;
        } else if (!vowels.includes(leftChar) && vowels.includes(rightChar)) {
            left++;
        } else {
            right--;
            left++;
        }
    }

    return arr.join("");
};