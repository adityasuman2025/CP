/*
    Given an array of lamps where lamp[i][0] is its coordinate on the line and lamp[i][1] reprents its range
    i.e. light[i] cover light from lamp[i][0] - lamp[i][1] to lamp[i][0] + lamp[i][1]
    return total count of points where there is no overlap of light from multiple lamps
*/


// O(n*r)
const lamps = [[-2, 3], [2, 1], [2, 3]];
function calc(arr) {
    const obj = {};

    arr.forEach(([idx, range]) => {
        for (let i = idx - range; i <= idx + range; i++) {
            obj[i] = Number(obj[i] || "0") + 1
        }
    });

    return Object.values(obj).filter(i => i === 1).length;
}
// console.log("ans", calc(lamps));

// O(nlogn)
function calc2(arr) {
    const obj = {};

    arr.forEach(([idx, range]) => {
        const start = idx - range, end = idx + range;
        obj[start] = (obj[start] || 0) + 1;
        obj[end + 1] = (obj[end + 1] || 0) - 1;
    });

    let c = 0, curr = 0;
    const sortedKeys = Object.keys(obj).sort((a, b) => a - b);
    for (let idx = 0; idx < sortedKeys.length - 1; idx++) {
        const key = sortedKeys[idx], nextKey = sortedKeys[idx + 1];

        curr += obj[key];
        if (curr === 1) c += (nextKey - key); // if at this point there is light from only 1 lamp, then checking till what point only 1 lamp light is there
    };

    return c;
}
console.log("ans", calc2(lamps));