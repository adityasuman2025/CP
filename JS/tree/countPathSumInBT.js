/*
https://leetcode.com/problems/path-sum-iii/description/

437. Path Sum III
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
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
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number}
 */


// ref: https://www.youtube.com/watch?v=UQzXYDN49cs
var pathSum = function(root, targetSum) {
    let c = 0;

    function util(node, targetSum) {
        if (!node) return;

        helper(node, targetSum);

        if (node.left) util(node.left, targetSum);
        if (node.right) util(node.right, targetSum);
    }

    function helper(node, targetSum) {
        if (!node) return;

        if (node.val === targetSum) c++;

        if (node.left) helper(node.left, targetSum - node.val);
        if (node.right) helper(node.right, targetSum - node.val);
    }

    util(root, targetSum)
    return c;
};