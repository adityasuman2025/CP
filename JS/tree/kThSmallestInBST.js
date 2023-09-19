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


// recursive
var kthSmallest = function(root, k) {
    let num;

    let c = 0;
    function inOrder(root, k) {
        if (!root) return;

        inOrder(root.left, k);

        c++;
        if (c === k) num = root.val;

        inOrder(root.right, k);
    }
    inOrder(root, k);

    return num;
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
