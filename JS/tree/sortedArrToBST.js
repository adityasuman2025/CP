/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

108. Convert Sorted Array to Binary Search Tree
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced
binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (arr) {

    function util(start, end) {
        if (start > end) return null;

        let mid = parseInt((start + end) / 2);

        let root = new TreeNode(arr[mid]);
        root.left = util(start, mid - 1);
        root.right = util(mid + 1, end);

        return root;
    }

    let start = 0, end = arr.length - 1;
    return util(start, end);
};