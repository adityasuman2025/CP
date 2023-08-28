/*
    1. Selection Sort: O(N^2) 
    2. Bubble Sort: O(N^2) 
    3. Merge Sort: O(NlogN) 
    4. Quick Sort: Randomized Quick Sort: O(NlogN), Normal Quick Sort: O(N^2) 
    5. Insertion Sort: O(N^2) 
    6. Heap Sort
*/


let arr = [9, 2, 12, 20, 15, 7, 10, 29, 16, 23, 17, 5, 27];
console.log("original arr", arr)

function swap(arr, index1, index2) {
    let temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
}



// goal is find minimum array value index in each iteration and swap it with i index
function selectionSort(arr) {
    let length = arr.length;
    let minIndex;

    for (let i = 0; i < length - 1; i++) {
        minIndex = i;

        for (let j = i + 1; j < length; j++) {
            if (arr[j] < arr[minIndex]) minIndex = j;
        }

        if (minIndex == i) continue;

        swap(arr, i, minIndex);
    }
}
// selectionSort(arr);
// console.log("selectionSort sorted arr", arr)



// goal is to compare every array element in each iteration and keep pushing the largest element to the end
function bubbleSort(arr) {
    let length = arr.length;

    for (let i = 0; i < length - 1; i++) {
        let isSwapped = false;

        for (let j = 0; j < length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                isSwapped = true;
                swap(arr, j, j + 1)
            }
        }

        if (!isSwapped) break;
    }
}
// bubbleSort(arr);
// console.log("bubbleSort sorted arr", arr)



// goal is to divide the array into two halves, sort each half, and then merge the sorted halves back together. This process is repeated until the entire array is sorted
// divide & conquer
let inversionCount = 0;
function mergeSort(arr) {
    let length = arr.length;

    if (length < 2) return;

    let mid = parseInt(length / 2);
    let leftArr = arr.slice(0, mid), rightArr = arr.slice(mid, length);

    mergeSort(leftArr);
    mergeSort(rightArr);
    merge(leftArr, rightArr, arr);
}

function merge(leftArr, rightArr, arr) {
    let lLength = leftArr.length, rLength = rightArr.length;
    let i = 0; l = 0, r = 0;

    while ((l < lLength) && (r < rLength)) {
        if (leftArr[l] < rightArr[r]) {
            arr[i] = leftArr[l];
            l++;
        } else {
            arr[i] = rightArr[r];
            r++;

            inversionCount += (lLength - l);
        }
        i++;
    }

    while (l < lLength) {
        arr[i] = leftArr[l];
        l++;
        i++
    }
    while (r < rLength) {
        arr[i] = rightArr[r];
        r++;
        i++;
    }
}
// mergeSort(arr);
// console.log("mergeSort sorted arr", arr)



// goal is to divide the array into 2 parts, using a partitionIdx, such that elements on the right of the partitionIdx is greater than element at partitionIdx and elements on the left of the partitionIdx is smaller than element at partitionIdx
// divide & conquer
function quickSort(arr, start, end) {
    if (start >= end) return;

    let partitionIdx = partition(arr, start, end);

    quickSort(arr, start, partitionIdx - 1);
    quickSort(arr, partitionIdx + 1, end);
}

function partition(arr, start, end) {
    // for choosing any random pivot
    let randomPivotIndex = Math.floor(Math.random() * (end - start + 1) + start);
    swap(arr, randomPivotIndex, end);
    // for choosing any random pivot

    let pivot = arr[end];

    let partitionIdx = start;
    for (let i = start; i < end; i++) {
        if (arr[i] <= pivot) {
            swap(arr, i, partitionIdx);
            partitionIdx++;
        }
    }

    swap(arr, partitionIdx, end);

    return partitionIdx;
}
// quickSort(arr, 0, arr.length - 1);
// console.log("quickSort sorted arr", arr)



function insertionSort(arr) {
    let length = arr.length;

    for (let i = 1; i < length; i++) {
        let holeIdx = i;
        let val = arr[i];

        while (holeIdx > 0 && (val < arr[holeIdx - 1])) {
            swap(arr, holeIdx, holeIdx - 1);

            holeIdx--;
        }
    }
}
insertionSort(arr);
console.log("insertionSort sorted arr", arr)