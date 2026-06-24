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

function reverse(str) {
    const ans = str.split("");

    let start = 0, end = str.length - 1;
    while (start < end) {
        while (start < end && !isAlphabet(str[start])) start++;
        while (start < end && !isAlphabet(str[end])) end--;

        if (start < end) {
            const temp = str[start];
            ans[start] = str[end];
            ans[end] = temp;
        }

        start++;
        end--;
    }

    return ans.join("");
}

const str = "##$!R@##$A#$!HU#@L";
const ans = reverseStr(str)
console.log("ans", ans)