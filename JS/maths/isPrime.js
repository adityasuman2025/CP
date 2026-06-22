/*
    https://www.geeksforgeeks.org/problems/prime-number2314/1

    Prime Number
*/

class Solution {
    isPrime(n) {
        // code here
        if (n < 2)
            return false;
        if (n < 4)
            return true;

        if (n % 2 == 0)
            return false;
        if (n % 3 == 0)
            return false;

        for (let i = 5; i * i <= n; i += 6) {
            if ((n % i === 0) || (n % (i + 2) === 0)) return false;
        }

        return true;
    }
}
