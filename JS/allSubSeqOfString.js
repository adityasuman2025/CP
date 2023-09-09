function getSubSeq(str) {
    let list = [];

    function util(start, out) {
        if (str === out) {
            list.push(out);
            return;
        }

        if (out) list.push(out);

        for (let i = start; i < str.length; i++) {
            util(i + 1, out + str[i]);
        }
    }
    util(0, "");

    return list;
}

let str = "abcd";
console.log(getSubSeq(str));