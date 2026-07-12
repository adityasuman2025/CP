/*
    https://leetcode.com/problems/maximum-product-subarray/submissions/2064562223/
*/

/**
 * @param {number[]} numbers
 * @return {number}
 */
var maxProductLimit = function(numbers) {
    if (numbers.length === 0) return 0;

    let maxProd = numbers[0];
    let minProd = numbers[0];
    let result = numbers[0];

    for (let i = 1; i < numbers.length; i++) {
        const num = numbers[i];

        if (num < 0) {
            const temp = maxProd;
            maxProd = minProd;
            minProd = temp;
        }

        maxProd = Math.max(num, maxProd * num);
        minProd = Math.min(num, minProd * num);

        result = Math.max(result, maxProd);
    }

    return result;
};
