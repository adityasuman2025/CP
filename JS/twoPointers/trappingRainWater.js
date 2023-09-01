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
var trap = function (height) {
    let n = height.length;

    let maxFromFront = [height[0]];
    let maxFromBack = [];

    let maxTillThis = height[0];
    for (let i = 1; i < n; i++) {
        maxTillThis = Math.max(maxTillThis, height[i]);
        maxFromFront[i] = maxTillThis;
    }

    maxTillThis = 0;
    for (let i = n - 1; i >= 0; i--) {
        maxTillThis = Math.max(maxTillThis, height[i]);
        maxFromBack[i] = maxTillThis;
    }

    let water = 0;
    for (let i = 1; i < n; i++) {
        water += (Math.min(maxFromFront[i], maxFromBack[i]) - height[i])
    }

    return water
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