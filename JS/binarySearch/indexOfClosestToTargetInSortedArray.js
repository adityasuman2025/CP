function indexOfClosestToTargetInSortedArray(arr, target) {
    if (target > arr[arr.length - 1]) return arr.length - 1;

    if (target < arr[0]) return 0;

    let start = 0, end = arr.length - 1;
    while (start <= end) {
        let mid = parseInt((start + end) / 2);

        if (arr[mid] === target) return mid;
        else if (target > arr[mid]) start = mid + 1;
        else end = mid - 1;
    }

    return start;
}

let arr = [1, 3, 5, 7];
const closest = indexOfClosestToTargetInSortedArray(arr, 2);
console.log("closest", closest);