function binarySearch(arr, toSearch) {
    let left = 0;
    let right = arr.length - 1;
    let middle;

    while (left < right) {
        middle = parseInt((left + right)/2); //left + Math.floor((right - left) / 2);

        if (toSearch == arr[middle]) {
            return true;
        } else if (toSearch > arr[middle]) {
            left = middle + 1;
        } else { // (toSearch < arr[middle])
            right = middle - 1;
        }
    }

    return false;
}

const toSearch = 2;
const arr = [ 2, 5, 9, 13, 14, 16, 18, 19, 24, 26, 28, 30, 31, 32, 34, 35, 39, 42, 45, 47, 49, 50, 52, 53, 55, 59, 63, 67, 70 ];

const isFound = binarySearch(arr, toSearch);
console.log(`${toSearch} found: ${isFound}`);