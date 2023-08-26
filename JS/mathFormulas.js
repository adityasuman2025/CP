process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let inputStringArr = [];

process.stdin.on('data', function (inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function () {
    inputStringArr = inputString.split('\n');

    main();
});

function main() {
    // const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
    // ws.write(result + '\n');
    // ws.end();

    const number = parseInt(inputStringArr[0]);
    const prime = parseInt(inputStringArr[1]);

    // const powerOfPrime = getPowerOfPrime(number, prime);
    // console.log("powerOfPrime", powerOfPrime, inputStringArr);

    // const factorialOfNumber = factorial(number);
    // console.log("factorialOfNumber", factorialOfNumber, inputStringArr);

    // const fibonacciNoAtPos = fibonacciNoAtPosition(number);
    // console.log("fibonacciNoAtPos", fibonacciNoAtPos, inputStringArr);

    // const fibonacciSeries = [];
    // fibonacciSeriesTillPosition(fibonacciSeries, number);
    // console.log("fibonacciSeries", fibonacciSeries);

    // const isNoPrime = isPrime(number);
    // console.log("isNoPrime", isNoPrime);

    // const primeNosTillNo = primeTillNumber(number);
    // console.log("primeNosTillNo", primeNosTillNo);

    const prFactor = primeFactors(number);
    console.log("prFactor", prFactor);
}

function getPowerOfPrime(number, prime) {
    let power = 0;
    while (number % prime == 0) {
        power++;
        number = number / prime;
    }

    return power;
}

function factorial(number) {
    if ([0, 1].includes(number)) return 1;

    return number * factorial(number - 1);
}

function fibonacciNoAtPosition(position) {
    if ([1, 2].includes(position)) return position - 1;

    return fibonacciNoAtPosition(position - 1) + fibonacciNoAtPosition(position - 2);
}

function fibonacciSeriesTillPosition(fibonacciSeries, position) {
    if ([1, 2].includes(position)) {
        fibonacciSeries[position - 1] = position - 1;
        return position - 1;
    }

    if (fibonacciSeries[position - 1]) {
        return fibonacciSeries[position - 1];
    }

    let thisPosFibo = fibonacciSeriesTillPosition(fibonacciSeries, position - 1) + fibonacciSeriesTillPosition(fibonacciSeries, position - 2);
    fibonacciSeries[position - 1] = thisPosFibo;
    return thisPosFibo;
}

function isPrime(number) {
    if (number < 2) {
        return false;
    }

    if (number < 4) {
        return true;
    }

    if ((number % 2 == 0) || (number % 3 == 0)) {
        return false;
    }

    for (let i = 5; i * i <= number; i = i + 6) {
        if ((number % i == 0) || (number % (i + 2) == 0)) {
            return false;
        }
    }

    return true;
}

function primeTillNumber(number) {
    let primes = [];

    if (number > 1) {
        primes = [2];
    }

    if (number > 2) {
        primes = [2, 3];
    }

    for (let i = 5; i < number;) {
        if (isPrime(i)) {
            primes.push(i);
        }

        if ((i + 2 < number) && isPrime(i + 2)) {
            primes.push(i + 2);
        }

        i += 6;
    }

    return primes;
}

function primeFactors(number) {
    let factors = {};

    // const primNos = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 35, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101];
    // primNos.forEach(primeNo => {
    //     while (number % primeNo == 0) {
    //         factors[primeNo] = factors[primeNo] ? (factors[primeNo] + 1): 1;
    //         number = number / primeNo;
    //     }
    // });

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

    if (number > 2) {
        factors[number] = 1;
    }

    return factors;
}