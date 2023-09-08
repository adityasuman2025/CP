/*
https://leetcode.com/problems/trapping-rain-water/

42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
*/


//approach 1 time: O(n), space: O(n)
var trap = function (arr) {
    let n = arr.length;

    let maxFromFront = [];
    maxFromFront.push(arr[0]);
    for (let i = 1; i < n; i++) {
        maxFromFront[i] = Math.max(maxFromFront[i - 1], arr[i]);
    }

    let maxFromBack = [];
    maxFromBack[n - 1] = arr[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        maxFromBack[i] = Math.max(maxFromBack[i + 1], arr[i]);
    }

    let water = 0;
    for (let i = 0; i < n; i++) {
        let temp = Math.min(maxFromFront[i], maxFromBack[i]) - arr[i];
        water += (temp > 0) ? temp : 0; // if temp is greater than 0 means some water can be stored here
    }

    return water;
};


//approach 2 - 2 pointer approach - time: O(n), space: O(1)
var trap = function (arr) {
    let n = arr.length;

    let left = 0, right = n - 1;
    let leftMax = 0, rightMax = 0;

    let water = 0;
    while (left <= right) {
        if (arr[left] < arr[right]) {
            if (arr[left] > leftMax) {
                leftMax = arr[left]
            } else {
                water += (leftMax - arr[left]);
            }
            left++
        } else {
            if (arr[right] > rightMax) {
                rightMax = arr[right]
            } else {
                water += (rightMax - arr[right]);
            }
            right--
        }
    }

    return water
};