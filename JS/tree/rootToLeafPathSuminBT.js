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

// DFS
var hasPathSum = function(node, targetSum) {
    if (!node) return false;

    if (!node.left && !node.right) {
        if (targetSum - node.val === 0) return true;
    }

    const hasLeft = hasPathSum(node.left, targetSum - node.val)
    const hasRight = hasPathSum(node.right, targetSum - node.val)
    if (hasLeft || hasRight) return true;

    return false;
};

// BFS
var hasPathSum = function(node, targetSum) {
    if (!node) return false;

    const q = [{ node, req: targetSum - node.val }];
    let i = 0;
    while (i < q.length) {
        const { node, req } = q[i];
        i++;

        if (!node.right && !node.left) {
            if (req === 0) return true;
        }

        if (node.left) q.push({ node: node.left, req: req - node.left.val });
        if (node.right) q.push({ node: node.right, req: req - node.right.val });
    }

    return false;
};