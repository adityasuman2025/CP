/*
https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

2390. Removing Stars From a String
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
 

Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
*/



/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function (s) {
    let stack = [];
    for (let i = 0; i < s.length; i++) {
        let char = s.charAt(i);
        if (char === "*") {
            stack.pop();
        } else {
            stack.push(char)
        }
    }

    return stack.join("");
};

var asteroidCollision = function (asteroids) {
    let len = asteroids.length;

    let stack = [asteroids[0]];
    let prevPeek = stack.peek();

    for (let i = 1; i < len; i++) {
        stack.push(asteroids[i]);
        let thisPeek = stack.peek();

        // 2 -5
        // 10 -5
        while (hasDiffSign(prevPeek, thisPeek) && stack.length) {
            console.log("prevPeek thisPeek", prevPeek, thisPeek);

            let bigger = getAbsBigger(prevPeek, thisPeek);
            stack.pop();
            stack.pop();

            if (isAbsEqual(prevPeek, thisPeek)) {
            } else {
                stack.push(bigger);
            }

            thisPeek = stack.peek();
            prevPeek = stack.peek2();
        }

        prevPeek = thisPeek;
    }

    return stack;
};

function isAbsEqual(no1, no2) {
    return (Math.abs(no1) === Math.abs(no2));
}

function getAbsBigger(no1, no2) {
    if (Math.abs(no1) > Math.abs(no2)) return no1;

    return no2;
}

function hasDiffSign(no1, no2) {
    if (isPos(no1) && isNeg(no2)) return true;
    if (isPos(no2) && isNeg(no1)) return true;

    return false;
}

function isNeg(num) {
    return num < 0;
}

function isPos(num) {
    return num > 0;
}

Array.prototype.peek = function () {
    return this[this.length - 1];
}
Array.prototype.peek2 = function () {
    return this[this.length - 2];
}