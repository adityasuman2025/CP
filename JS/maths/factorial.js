/*
    https://www.geeksforgeeks.org/problems/factorial5739/1

    Factorial
*/

/**
 * @param {number} n
 * @returns {number}
 */

class Solution {
    factorial(n) {
        // code here
        let map = new Map();
        map.set(0, 1);
        map.set(1, 1);

        function util(n) {
            if (map.has(n)) return map.get(n);

            map.set(n, n * util(n - 1));
            return map.get(n);
        }

        return util(n);
    }
}
