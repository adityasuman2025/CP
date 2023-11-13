// process.stdin.resume();
// process.stdin.setEncoding('utf-8');

// let inputString = '';
// let inputStringArr = [];

// process.stdin.on('data', function (inputStdin) {
//     inputString += inputStdin;
// });

// process.stdin.on('end', function () {
//     inputStringArr = inputString.split('\n');

//     main();
// });

// function main() {
//     // const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
//     // ws.write(result + '\n');
//     // ws.end();

//     const number = parseInt(inputStringArr[0]);
//     const prime = parseInt(inputStringArr[1]);

// }

function gcd(a, b) {
    if (!b) return a;

    gcd(b, a % b);
}


// index: 0 1 2 3
// value: 0 1 1 2
function fibbonaci(n) {
    let memo = [0, 1, 1];

    function fibb(n) {
        if (n < 2) return n;
        if (n < 3) return n - 1;

        const f = memo.hasOwnProperty(n - 1) ? memo[n - 1] : fibb(n - 1);
        const s = memo.hasOwnProperty(n - 2) ? memo[n - 2] : fibb(n - 2);
        memo[n] = f + s;

        return memo[n];
    }
    fibb(n);

    return memo[n];
}
let ans = fibbonaci(10);
// console.log("fibbonaci", ans)


// n! = n * (n-1)!
function factorial(n) {
    let memo = [1, 1];

    function fact(n) {
        if (n < 2) return 1;

        const prev = memo.hasOwnProperty(n - 1) ? memo[n - 1] : fact(n - 1);
        memo[n] = n * prev;
        return memo[n]
    }
    fact(n);

    return memo[n];
}
let ans1 = factorial(5);
// console.log("factorial", ans1)


// get power of a prime no in number
function getPowerOfPrime(number, prime) {
    let c = 0;

    while (number > 1) {
        number = parseInt(number / prime);
        c++;
    }

    return c;
}
let ans2 = getPowerOfPrime(81, 3);
// console.log("getPowerOfPrime", ans2)


// checks if a no is prime
function isPrime(n) {
    if (n < 2) return false;
    if (n < 4) return true;

    if ((n % 2 === 0) || (n % 3 === 0)) return true;

    for (let i = 5; i * 1 <= n; i += 6) {
        if ((n % i === 0) || (n % (i + 2) === 0)) return false;
    }

    return true;
}


// 2 3 5 7 11 13 17 19...
function primeTillNumber(number) {
    let primes = [];

    if (number > 1) primes = [2];

    if (number > 2) primes = [2, 3];

    for (let i = 5; i < number; i += 6) {
        if (isPrime(i)) primes.push(i);

        if ((i + 2 < number) && isPrime(i + 2)) primes.push(i + 2);
    }

    return primes;
}


// function to get prime factors of a number
function primeFactors(number) {
    let factors = {};

    let i = 2;
    while (number % i == 0) {
        factors[i] = factors[i] ? (factors[i] + 1) : 1;
        number = number / i;
    }

    for (i = 3; i * i <= number; i += 2) {
        while (number % i == 0) {
            factors[i] = factors[i] ? (factors[i] + 1) : 1;
            number = number / i;
        }
    }

    if (number > 2) factors[number] = 1;

    return factors;
}



// ref: https://bigfrontend.dev/problem/the-angle-between-hour-hand-and-minute-hand-of-a-clock
function angleBWHourAndMinuteHand() {
    let [hours, minutes] = time.split(":");

    minutes = Number(minutes);
    hours = Number(hours);

    if (hours >= 12) hours = hours - 12; // because a clock has hand till 12 only

    let minuteAngle = (minutes / 60) * 360; // because 60 mins equals to 360 degree
    let hourAngle = ((hours / 12) * 360) + ((minutes / 60) * 30); // because 12 hours equals to 360 degree and hour hand move a little as minute hand move
    // on full round of minute hand (360 degree) hour hand moves by 30 degree

    let angle = Math.abs(minuteAngle - hourAngle);
    angle = angle > 180 ? 360 - angle : angle; // because we have to return smallest angle

    return Math.round(angle);
}
console.log(angleBWHourAndMinuteHand('12:00')); // 0
console.log(angleBWHourAndMinuteHand('23:30')); // 165
