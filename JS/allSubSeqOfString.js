let list = [];

function subSeq(input, output) {
    if (input.length == 0) {
        if (output != "") list.push(output);
        return;
    }
    
    subSeq(input.substring(1), output);
    subSeq(input.substring(1), output + input[0]);
}

let str = "abcd";
subSeq(str, "")
console.log("list", list)