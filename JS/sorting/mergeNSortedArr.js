/*
https://bigfrontend.dev/problem/merge-sorted-arrays

81. merge sorted arrays

You are given a list of sorted non-descending integer arrays, write a function to merge them into one sorted non-descending array.

merge(
  [
    [1,1,1,100,1000,10000],
    [1,2,2,2,200,200,1000],
    [1000000,10000001],
    [2,3,3]
  ]
)
// [1,1,1,1,2,2,2,2,3,3,100,200,200,1000,1000,10000,1000000,10000001]
*/


/**
 * @param {number[][]} arrList
 * non-descending integer array
 * @return {number[]} 
 */
// time: O(nk), space: O(nk)
function merge(arrList) {
    let resp = [];

    let pointer = new Array(arrList.length).fill(0);
    let totalLength = 0, isLengthDone = false;

    while (true) {
        let minI, minJ;
        for (let i = 0; i < arrList.length; i++) {
            if (!isLengthDone) totalLength += arrList[i].length; // for storing the total no of elements in arrList

            if (minI === undefined || minJ === undefined) {
                if (pointer[i] < arrList[i].length) {
                    minI = i;
                    minJ = pointer[i];
                }
            } else {
                if (arrList[i][pointer[i]] < arrList[minI][minJ]) {
                    minI = i;
                    minJ = pointer[i];
                }
            }
        }
        isLengthDone = true;

        if ((minI === undefined || minJ === undefined)) break; // if all elements of the arrList has been picked into resp then breaking the loop

        resp.push(arrList[minI][minJ]);
        pointer[minI] = pointer[minI] + 1;

        if (resp.length >= totalLength) break; // if all elements of the arrList has been picked into resp then breaking the loop
    }

    return resp;
}

// const res = merge([
//   [0, 3],[2, 4],[1, 5]
// ]);
// console.log(res);

const res2 = merge([
    [1], [], [2]
]);
console.log(res2);

const res3 = merge([]);
console.log(res3);

const res4 = merge([
    [1, 1, 1, 100, 1000, 10000],
    [1, 2, 2, 2, 200, 200, 1000],
    [1000000, 10000001],
    [2, 3, 3]
]);
console.log(res4);