let arr = [0,1,2,3,4,5,6,7,8,9];
console.log("old arr", arr);

function reverse(arr, startIndex, endIndex) {
    while (startIndex < endIndex) {
        let temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;

        startIndex++;
        endIndex--;
    }
}

reverse(arr, 2, 7);
console.log("new arr", arr);