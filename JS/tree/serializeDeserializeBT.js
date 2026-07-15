/*
    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    if (!root) return "";

    const ans = [];

    const q = [root];
    let i = 0;
    while (i < q.length) {
        const node = q[i];
        ans.push(node ? node.val : null);

        if (node) {
            q.push(node.left);
            q.push(node.right);
        }

        i++
    }

    return ans.join(",");
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    if (!data) return null;
    const arr = data.split(",");

    let head = 0;
    const root = new TreeNode(parseInt(arr[head]));
    const q = [root];

    let childPointer = 1;
    while (head < q.length && childPointer < arr.length) {
        const curr = q[head++];

        if (arr[childPointer] && arr[childPointer] !== "null") {
            curr.left = new TreeNode(parseInt(arr[childPointer]));
            q.push(curr.left);
        }
        childPointer++;

        if (arr[childPointer] && arr[childPointer] !== "null") {
            curr.right = new TreeNode(parseInt(arr[childPointer]));
            q.push(curr.right);
        }
        childPointer++;
    }

    return root;
};
/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */