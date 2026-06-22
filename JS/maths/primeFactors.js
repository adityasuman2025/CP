/*
    https://www.geeksforgeeks.org/problems/prime-factor-of-a-number/1

    All Prime Factors in Any Order
*/

class Solution {
    primeFactors(num) {
        let primes = new Map();
        const ans = [];

        while (num % 2 === 0) {
            num = num / 2;
            setPrime(2);
        }

        while (num % 3 === 0) {
            num = num / 3;
            setPrime(3);
        }

        for (let i = 5; i * i <= num; i += 6) {
            while (num % i === 0) {
                num = num / i;
                setPrime(i);
            }

            while (num % (i + 2) === 0) {
                num = num / (i + 2);
                setPrime(i + 2);
            }
        }

        if (num > 1) setPrime(num);

        function setPrime(val) {
            const c = primes.get(val) || 0;
            primes.set(val, c + 1);
            ans.push(val)
        }

        return ans
    }
}
