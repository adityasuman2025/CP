/*
Let's say you already have a function to check if a letter is alphabet (A, B, C, etc) or not, then using this information,
find a way to reverse only the alphabets in the given string and keep other characters in its same place.
Example

Input - ##$!M@##$A#$!A#@N
Output - ##$!N@##$A#$!A#@M [ MAAN get reversed ]

Input - ##$!R@##$A#$!HU#@L
Output - ##$!L@##$UH#$!A#@R [RAHUL get reversed 1
*/

function isAlphabet(char) {
    let ascii = char.toUpperCase().charCodeAt(0);

    if (ascii >= 65 && ascii <= 90) return true;

    return false;
}

function reverseStr(str) {
    let n = str.length;

    let alphabetIndices = [];
    for (let i=0; i<n; i++) {
        if (isAlphabet(str[i])) alphabetIndices.push(i);
    }

    let start = 0, end = alphabetIndices.length - 1;

    let strArr = str.split("");
    while (start < end) {
        let startIdx = alphabetIndices[start];
        let endIdx = alphabetIndices[end];

        let temp = strArr[startIdx];
        strArr[startIdx] = strArr[endIdx];
        strArr[endIdx] = temp;

        start++;
        end--;
    }

    return strArr.join("");
}

const str = "##$!R@##$A#$!HU#@L";
const ans = reverseStr(str)
console.log("ans", ans)