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

var maxVowels = function (s, k) {
    let vowels = ["a", "e", "i", "o", "u"];

    let vowC = 0, maxVowC = 0;
    for (let i = 0; i < k; i++) {
        let char = s.charAt(i);
        if (vowels.includes(char)) vowC++;

        maxVowC = Math.max(maxVowC, vowC);
    }

    let left = 0;
    for (let right = k; right < s.length; right++) {
        let char = s.charAt(right);

        if (vowels.includes(char)) vowC++;
        if (vowels.includes(s.charAt(left))) vowC--;

        maxVowC = Math.max(maxVowC, vowC);
        left++;
    }

    return maxVowC;
};