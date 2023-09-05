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

const toSearch = 2;
const arr = [2, 5, 9, 13, 14, 16, 18, 19, 24, 26, 28, 30, 31, 32, 34, 35, 39, 42, 45, 47, 49, 50, 52, 53, 55, 59, 63, 67, 70]; //it must be sorted, then only binary search will work

const foundIdx = binarySearch(arr, toSearch);
console.log(`${toSearch} found: ${foundIdx}`);