process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let inputStringArr = [];

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
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

    const binary = decimalIntoBinary(number);
    console.log("binary", binary, inputStringArr)
}

function getPowerOfPrime(number, prime) {
    let power = 0;
    while (number % prime == 0) {
        power ++;
        number = number/prime;
    }

    return power;
}

function decimalIntoBinary(number) {
    let binary = "";

    while (number >= 2) {
        let remainder = number % 2;
        binary = remainder + binary;

        number = parseInt(number/2);
    }
    binary = number + binary;

    return binary;
}