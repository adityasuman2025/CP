/*
    https://leetcode.com/problems/complement-of-base-10-integer/

    1009. Complement of Base 10 Integer
*/

/**
 * @param {number} n
 * @return {number}
 */
var bitwiseComplement = function(n) {
    const binary = decimalToBinary(n);
    const flipped = binary.map(item => item === 0 ? 1 : 0);

    return binaryToDecimal(flipped);
};

function binaryToDecimal(num) {
    let ans = 0;

    let pow = num.length - 1;
    for (let i = 0; i < num.length; i++) {
        const item = num[i];

        ans += (item * Math.pow(2, pow))
        pow--;
    }

    return ans;
}

function decimalToBinary(num) {
    let ans = [];

    while (num > 1) {
        const rem = num % 2;
        ans.push(rem);

        num = Math.floor(num / 2);
    }
    ans.push(num);
    return ans.reverse();
}