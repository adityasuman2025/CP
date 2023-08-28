let arr = [2, 5, 7, 9, 10, 12, 15, 16, 17, 20, 23, 27, 29];

function binarySearch(arr, toSearch) {
    let left = 0, right = arr.length - 1, mid;

    while (left <= right) {
        mid = parseInt((left + right) / 2);

        if (arr[mid] === toSearch) {
            return mid;
        } else if (toSearch > arr[mid]) {
            left = mid + 1;
        } else { //if (toSearch < arr[mid]) 
            right = mid - 1;
        }
    }

    return -1;
}

const idx = binarySearch(arr, 16);
console.log("idx", idx)