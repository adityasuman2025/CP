/*
https://leetcode.com/problems/next-permutation/description/

31. Next Permutation
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
*/

var nextPermutation = function(arr) {
    let n = arr.length;

    // find the dip (non increasing index) from behind
    let dipIdx = -1;
    for (let i = n - 1; i > 0; i--) {
        if (arr[i - 1] < arr[i]) {
            dipIdx = i - 1;
            break;
        }
    }

    if (dipIdx === -1) { // if the given array is last permutation, then the next permutation will be the first permutation, i.e reverse of the given array
        reverse(arr, 0, n - 1);
    } else {
        // find the nearest/next greater element to the dip element
        let nearestGreaterIdx;
        for (let i = dipIdx + 1; i < n; i++) {
            if (arr[i] > arr[dipIdx]) {
                nearestGreaterIdx = i;
            }
        }

        // swapping the dip with its nearest greater element to its right
        swap(arr, dipIdx, nearestGreaterIdx);

        // reversing the right part of the dip (they will be in sorted order)
        reverse(arr, dipIdx + 1, n - 1);
    }
};

function reverse(arr, start, end) {
    while (start < end) {
        let temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        end--;
        start++;
    }
}

function swap(arr, i, j) {
    const temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


/*
// ref: https://www.youtube.com/watch?v=JDOXKqF60RQ

Approach

1. Find the first decreasing index moving from end to start
E.g. [7, 2, 3, 1, 5, 4, 3, 2, 0] num 1 is the first decreasing index going from the end backwards
2. Swap num 1 with the next large num to its right which is 2
[7, 2, 3, 2, 5, 4, 3, 1, 0]
3. Reverse arr to its right
[7, 2, 3, 2, 0, 1, 3, 4, 5]
4. If there is no next permutation reverse the array
*/