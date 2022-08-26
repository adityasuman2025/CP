process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let inputArr = [];
process.stdin.on("data", (input) => inputString += input);
process.stdin.on("end", () => {
    inputArr = inputString.split("\n");

    main();
});

function main() {
    let arr = inputArr[0].split(" ").map(no => parseInt(no));
    console.log("original arr", arr)

    selectionSort(arr);
    console.log("sorted arr", arr)
}
/*
    Bubble Sort
    Selection Sort
    Insertion Sort
    Quick Sort
    Merge Sort
*/

function selectionSort(arr) {
    let length = arr.length;

    for (let i = 0; i < length; i++) {
        let minIndex = i;

        for (let j = i+1; j < length; j++) {
            if (arr[j] < arr[minIndex]) minIndex = j;
        }

        if (minIndex == i) continue;

        let temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}