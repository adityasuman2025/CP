function getSubString(str) {
    let substrs = [];

    for (let i = 0; i < str.length; i++) {
        for (let j = i + 1; j < str.length + 1; j++) {
            substrs.push(str.substring(i, j))
        }
    }

    return substrs;
}

getSubString("madam");