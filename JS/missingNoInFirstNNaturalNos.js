/*
    To find one missing number in the array when every element of the array has difference of one
    and numbers are first 'n' natural numbers but array is not sorted.
    
    Example
    Input- [1, 4, 3, 6, 2]
    Output - 5 ( In this array 5 is missing number when we see order 1, 2, 3, 4, 6)
    
    Do it in O(n) time and 0(1) space.

    make it generic that we need to find 'k' missing numbers
*/


//in complete //not working

function missingNos(arr, k) {
    let n = arr.length + k;

    let totalSum = n*(n+1)/2;
    let sum = 0;
    arr.forEach(item => sum += item);

    return totalSum - sum;

    // arr.forEach((item, i) => {
    //     arr[item - 1] = 1;
    // });
    // console.log("arr", arr)
}

let arr = [7, 4, 3, 6, 2, 5];
let ans = missingNos(arr, 2);

console.log("ans", ans)