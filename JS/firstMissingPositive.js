/*
    https://leetcode.com/problems/first-missing-positive/

    First Missing Positive
    Given an unsorted integer array nums, return the smallest missing positive integer.
    You must implement an algorithm that runs in O(n) time and uses constant extra space.
    

    Example 1:
    Input: nums = [1,2,0]
    Output: 3
    Explanation: The numbers in the range [1,2] are all in the array.

    Example 2:
    Input: nums = [3,4,-1,1]
    Output: 2
    Explanation: 1 is in the array but 2 is missing.

    Example 3:
    Input: nums = [7,8,9,11,12]
    Output: 1
    Explanation: The smallest positive integer 1 is missing.
*/


/**
 * @param {number[]} nums
 * @return {number}
*/
function firstMissingPositive(arr) {
    let N = arr.length;
    
    for (let i = 0; i < N; i++) {
       while ((arr[arr[i]-1] != arr[i]) && (arr[i] >= 1 && arr[i] <= N)) {
            let temp = arr[arr[i]-1];
            arr[arr[i]-1] = arr[i];
            arr[i] = temp;
        }
    }
    
    for (let i = 1; i <= N; i++) { 
        if (arr[i-1] != i) { 
            return i;
        } 
    }
    
    return N+1;
}