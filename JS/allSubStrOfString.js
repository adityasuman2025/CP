// All SubStrings of a String
function subString(str) {
    const len = str.length;

    const ans = [];
    function dfs(start, out) {
        if (out) ans.push(out);

        if (start >= len) return;

        dfs(start + 1, out + str[start])
    }
    for (let i = 0; i < len; i++) dfs(i, "");

    return ans;
}
const str = "aditya";
const res = subString(str);
console.log("subString", res);