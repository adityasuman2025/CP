// ref: https://bigfrontend.dev/problem/roman-numerals-to-integer
const SYMBOL_TO_NO = { "I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000 };
function romanToInteger(str) {
    let res = 0;

    for (let i = 0; i < str.length; i++) {
        let char = str[i];

        if (SYMBOL_TO_NO[char] < SYMBOL_TO_NO[str[i + 1]]) {
            let temp = SYMBOL_TO_NO[str[i + 1]] - SYMBOL_TO_NO[char];
            res += temp;
            i++;
        } else {
            res += SYMBOL_TO_NO[char];
        }
    }

    return res;
}
console.log(romanToInteger('MCMXCIX')); // 1999
console.log(romanToInteger('MMMCDXX')); // 3420




// ref: https://bigfrontend.dev/problem/integer-to-roman
const romanSymbols = [
    { symbol: 'M', value: 1000 },
    { symbol: 'CM', value: 900 },
    { symbol: 'D', value: 500 },
    { symbol: 'CD', value: 400 },
    { symbol: 'C', value: 100 },
    { symbol: 'XC', value: 90 },
    { symbol: 'L', value: 50 },
    { symbol: 'XL', value: 40 },
    { symbol: 'X', value: 10 },
    { symbol: 'IX', value: 9 },
    { symbol: 'V', value: 5 },
    { symbol: 'IV', value: 4 },
    { symbol: 'I', value: 1 },
];

function integerToRoman(num) {
    let char = "";

    romanSymbols.forEach(roman => {
        const repeatCount = parseInt(num / roman.value);
        char += repeatChar(roman.symbol, repeatCount);

        num = num % roman.value;
    })

    return char;
}

function repeatChar(char, times) {
    let res = "";
    for (let i = 0; i < times; i++) res += char;

    return res;
}