function decimalToBinary(num) {
    let binary = "";

    let no = num;
    while (no) {
        let rem = no % 2;
        binary = rem + binary;

        no = parseInt(no / 2);
    }

    console.log("binary of", num, "is", binary)
}

function binaryToDecimal(binary) {
    let binStr = String(binary), len = binStr.length;

    let no = 0;
    for (let i = len - 1; i >= 0; i--) {
        no += Number(binStr[i]) * Math.pow(2, len - 1 - i)
    }

    console.log("decimal of", binary, "is", no)
}


const number = 100;
decimalToBinary(number);


const binary = 10011100001111;
binaryToDecimal(binary);