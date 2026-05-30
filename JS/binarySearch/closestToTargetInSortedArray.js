function closestToTargetInSortedArray(arr, toFind) {
    let start = 0, end = arr.length - 1;

    if (toFind <= arr[0]) return arr[0];
    if (toFind >= arr[end]) return arr[end];

    while (start <= end) {
        let mid = Math.floor((end + start) / 2);

        if (arr[mid] === toFind) return arr[mid];
        else if (toFind > arr[mid]) start = mid + 1
        else end = mid - 1;
    }

    if (Math.abs(arr[end] - toFind) < Math.abs(arr[start] - toFind)) return arr[end];
    else return arr[start];
}

let arr = [1, 3, 5, 7];
const closest = closestToTargetInSortedArray(arr, 2);
console.log("closest", closest);