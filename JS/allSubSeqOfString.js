// All SubSequence of a String
function subString(str) {
    const len = str.length;

    const ans = [];
    function dfs(start, out) {
        if (out && start === len) ans.push(out);

        if (start >= len) return;

        dfs(start + 1, out + str[start]);
        dfs(start + 1, out);
    }
    dfs(0, "");

    return ans;
}
const str = "aditya";
const res = subString(str);
console.log("subString", res);