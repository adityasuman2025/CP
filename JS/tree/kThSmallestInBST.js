/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

230. Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
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
 * @param {number} k
 * @return {number}
 */

// recursive
var kthSmallest = function(root, k) {
    let nums, c = 0;

    function inOrder(root) {
        if (!root) return;

        inOrder(root.left);

        c++;
        if (c === k) {
            nums = root.val
            return;
        }

        inOrder(root.right);
    }
    inOrder(root)

    return nums;
};

// iterative
var kthSmallest = function(root, k) {
    let num;

    let c = 0;
    let stack = [], curr = root;
    while (stack.length || curr) {
        while (curr) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();

        c++;
        if (c === k) {
            num = curr.val;
            break;
        }

        curr = curr.right;
    }

    return num;
};
