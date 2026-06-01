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

function merge(arrList) {
    if (!arrList.length) return arrList;

    let result = arrList[0];

    for (let i = 1; i < arrList.length; i++) {
        result = mergeTwoSorted(result, arrList[i]);
    }

    return result;
}

function mergeTwoSorted(a, b) {
    let result = [];

    let i = 0, j = 0;
    while (i < a.length && j < b.length) {
        if (a[i] <= b[j]) {
            result.push(a[i]);
            i++;
        } else {
            result.push(b[j]);
            j++;
        }
    }

    while (i < a.length) {
        result.push(a[i]);
        i++;
    }

    while (j < b.length) {
        result.push(b[j]);
        j++;
    }

    return result;
}