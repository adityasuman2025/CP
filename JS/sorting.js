process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let inputArr = [];
process.stdin.on("data", (input) => inputString += input);
process.stdin.on("end", () => {
    inputArr = inputString.split("\n");

    main();
});

/*
    Bubble Sort
    Selection Sort
    Insertion Sort
    Quick Sort
    Merge Sort
*/

function main() {
    let arr = inputArr[0].split(" ").map(no => parseInt(no));
    console.log("original arr", arr)

    quickSort(arr, 0, arr.length - 1);
    console.log("sorted arr", arr)
}

function swap(arr, index1, index2) {
    let temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
}

function selectionSort(arr) {
    let length = arr.length;

    for (let i = 0; i < length; i++) {
        let minIndex = i;

        for (let j = i+1; j < length; j++) {
            if (arr[j] < arr[minIndex]) minIndex = j;
        }

        if (minIndex == i) continue;

        swap(arr, i, minIndex);
    }
}

function bubbleSort(arr) {
    let length = arr.length;

    for (let i = 0; i < length - 1; i++) {
        let isSwapped = false;

        for (let j = 0; j < length - 1 - i; j++) {
            if (arr[j] > arr[j+1]) {
                isSwapped = true;
                swap(arr, j, j+1) 
            }
        }

        if (!isSwapped) break;
    }
}

function mergeSort(arr) {
    let length = arr.length;

    if (length < 2) return;

    let mid = parseInt(length / 2);

    let leftArr = [];
    for (let i = 0; i < mid; i++) {
        leftArr.push(arr[i]);
    }

    let rightArr = [];
    for (let i = mid; i < length; i++) {
        rightArr.push(arr[i]);
    }

    mergeSort(leftArr);
    mergeSort(rightArr);
    merge(leftArr, rightArr, arr);
}

function merge(leftArr, rightArr, arr) {
    let leftLen = leftArr.length;
    let rightLen = rightArr.length;

    let i, j, k = 0;

    while ((i < leftLen) && (j < rightLen)) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i];
            i++;
        } else {
            arr[k] = rightArr[j];
            j++;
        }

        k++
    }

    while (i < leftLen) {
        arr[k] = leftArr[i];
        i++;
        k++;
    }

    while (j < rightLen) {
        arr[k] = rightArr[j];
        j++;
        k++;
    }
}

function quickSort(arr, start, end) {
    if (start < end) {
        let pIndex = partition(arr, start, end);

        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }
}

function partition(arr, start, end) {
    // for choosing any random pivot
    let randomPivotIndex = Math.floor(Math.random() * (end-start+1) + start);
    swap(arr, randomPivotIndex, end);
    // for choosing any random pivot

    let pivot = arr[end];

    let pIndex = start;
    for (let i = start; i < end; i++) {
        if (arr[i] <= pivot) {
            swap(arr, i, pIndex);
            pIndex++;
        }
    }

    swap(arr, pIndex, end);

    return pIndex;
}