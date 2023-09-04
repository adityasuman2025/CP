/*
https://leetcode.com/problems/path-sum/description/


112. Path Sum
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.


Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
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
 * @return {boolean}
 */
var hasPathSum = function (root, targetSum) {
    let has = false;

    function pathSum(root, targetSum) {
        if (!root || has) return;

        if (targetSum === root.val && !root.left && !root.right) has = true; // if the left target sum is equal to the node val and that node is a leaf, i.e. node.left == null && node.right == null

        if (!has) pathSum(root.left, targetSum - root.val); // if already found a target sum then not looking again // going left with target sum subtracted with that node val 
        if (!has) pathSum(root.right, targetSum - root.val); // if already found a target sum then not looking again // going right with target sum subtracted with that node val 
    }
    pathSum(root, targetSum);

    return has;
};