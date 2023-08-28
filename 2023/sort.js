let arr = [9, 2, 12, 20, 15, 7, 10, 29, 16, 23, 17, 5, 27];
console.log("original arr", arr)
/*
    1. Selection Sort
    2. Bubble Sort
    3. Merge Sort
    4. Quick Sort
    5. Insertion Sort
    6. Heap Sort
*/

function selectionSort(arr) {
    let length = arr.length;
    let minIdx;

    for (let i = 0; i < length - 1; i++) {
        minIdx = i;
        for (let j = i + 1; j < length; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
        }

        if (minIdx !== i) { // swap
            let temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    console.log("selectionSort arr", arr)
}
// selectionSort(arr);

function bubbleSort(arr) {
    let length = arr.length;

    for (let i = 0; i < length - 1; i++) {
        let swapped = false;

        for (let j = 0; j < length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                swapped = true;
            }
        }

        if (!swapped) break;
    }

    console.log("arr", arr)
}
// bubbleSort(arr);

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

            inversionCount = inversionCount + (lLength - l)
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
// console.log("arr", arr)

function quickSort(arr, start, end) {
    if (start >= end) return;

    const pivotIdx = partition(arr, start, end);

    quickSort(arr, start, pivotIdx - 1);
    quickSort(arr, pivotIdx + 1, end);
}

function partition(arr, start, end) {
    const randomIdx = Math.floor(Math.random() * (end - start + 1) + start);
    console.log("randomIdx", randomIdx)

    // swap end index with randomIdx of array
    let temp = arr[end];
    arr[end] = arr[randomIdx];
    arr[randomIdx] = temp;

    const pivot = arr[end];

    let pivotIdx = start;
    for (let i = start; i < end; i++) {
        if (arr[i] <= pivot) {
            let temp = arr[i];
            arr[i] = arr[pivotIdx];;
            arr[pivotIdx] = temp;
            pivotIdx++;
        }
    }

    // swapping pivotIdx with end
    let temp2 = arr[end];
    arr[end] = arr[pivotIdx];;
    arr[pivotIdx] = temp2;

    return pivotIdx;
}
quickSort(arr, 0, arr.length - 1);
console.log("arr", arr)

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

    console.log("arr", arr)
}
insertionSort(arr);