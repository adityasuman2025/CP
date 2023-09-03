/*
https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1

Smallest distinct window
Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.

 

Example 1:
Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"

Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
*/

let input = "ABAAbCaBB"; //AbCaB 3-7

let uniqueCharsSet = new Set();
for (let i=0; i<input.length; i++) uniqueCharsSet.add(input[i]);
let uniqueCharsSetLen = uniqueCharsSet.size;
console.log("uniqueCharsSetLen", uniqueCharsSetLen)

let minWindowLength = input.length;
let charToCountMapping = {};
let start = 0, end = 0;
while (start <= end && (end < input.length)) {
    if (Object.keys(charToCountMapping).length == uniqueCharsSetLen) {
        let thisWindowLength = Object.values(charToCountMapping).reduce((acc, item) => { return acc + item }, 0);
        minWindowLength = Math.min(minWindowLength, thisWindowLength);

        console.log(thisWindowLength, charToCountMapping, start, end)

        let char = input[start];
        if (charToCountMapping[char] > 1) {
            charToCountMapping[char] = charToCountMapping[char] - 1;

            thisWindowLength = Object.values(charToCountMapping).reduce((acc, item) => { return acc + item }, 0);
            minWindowLength = Math.min(minWindowLength, thisWindowLength);
            console.log(thisWindowLength, charToCountMapping, start, end)
        } else {           
            delete charToCountMapping[char];

            console.log(charToCountMapping, "deleted ", char)
            end++;
        }

        start++;
    } else {
        let char = input[end];
        charToCountMapping[char] = charToCountMapping[char] >= 0 ? charToCountMapping[char] + 1 : 1;
        console.log(charToCountMapping, start, end)

        if (Object.keys(charToCountMapping).length != uniqueCharsSetLen) end++;
    }
}

console.log("minWindowLength", minWindowLength)

// // this does not work
// let input = "GEEKSGEEKSFOR";
// let output = findSubString(input);
// console.log("output", output);

// function findSubString(str) {
//     let uniqueCharSet = new Set();
//     for (let i = 0; i<str.length; i++) uniqueCharSet.add(str[i])

//     let windowSet = new Set();

//     let maxLen = 0;
//     let left = 0;
//     for (let right = 0; right<str.length; right++) {
//         let temp = str[right];

//         while (windowSet.has(temp)) {
//             windowSet.delete(str[left]);
//             left++;
//         }
//         windowSet.add(temp);
//         console.log("windowSet", windowSet)
//         if (uniqueCharSet.size == windowSet.size)
//             maxLen = Math.max(maxLen, right - left + 1)
//     }

//     return maxLen;
// }