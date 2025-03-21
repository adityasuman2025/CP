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
function merge(arr) {
  let len = arr.length;

  let idxArr = new Array(len).fill(0);
  let allLen = arr.reduce((acc, arr) => acc + arr.length, 0);
  
  let ans = [];
  while (allLen) {
    let minVal = Number.MAX_SAFE_INTEGER
    let minValIdx = -1;

    for (let i=0; i<len; i++) {
      if (arr[i][idxArr[i]] && arr[i][idxArr[i]] < minVal) {
        minVal = arr[i][idxArr[i]];
        minValIdx = i;
      }
    }

    ans.push(minVal);
    idxArr[minValIdx] = idxArr[minValIdx] + 1;

    allLen--;
  }

  return ans;
}

let arr = [
  [1,1,1,100,1000,10000],
  [1,2,2,2,200,200,1000],
  [1000000,10000001],
  [2,3,3]
];
console.log(merge(arr))
