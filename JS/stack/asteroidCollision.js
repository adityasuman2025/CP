/*
https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75

735. Asteroid Collision
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
*/


/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function (asteroids) {
    let stack = [asteroids[0]];
    let prevPeek = stack.peek();

    for (let i = 1; i < asteroids.length; i++) {
        stack.push(asteroids[i]);
        let thisPeek = stack.peek();

        // if prevPeek is positve only then it can collide with any 
        // because positive direction is -> and negative direction is <-
        // prev this can collide only if their direction is like this
        // -> <- (positive negative)
        while ((prevPeek > 0) && hasDiffSign(prevPeek, thisPeek) && stack.length) {
            let bigger = getAbsBigger(prevPeek, thisPeek);
            stack.pop();
            stack.pop();

            // if the two asteroids are of same size they will destroy each other
            // so new asteriod will not be added 
            if (!isAbsEqual(prevPeek, thisPeek)) stack.push(bigger);

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