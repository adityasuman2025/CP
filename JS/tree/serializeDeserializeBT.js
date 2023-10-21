/*
https://bigfrontend.dev/problem/serialize-and-deserialize-binary-tree

110. serialize and deserialize binary tree

Can you transform(serialize) a binary tree into a string and restore(deserialize) a binary tree from the string? Just like what JSON.stringify() and JSON.parse() do.

For example, for a tree from 91. invert a binary tree


BFE.dev would serialize it to [1,2,3,4,null,null,5,6,7,8,null,null,null,null,9]

But there are more ways of doing it rather than above, any would be fine as long as your deserialize() and serialize() work as a pair.
*/

// This is the class for the node
// you can use this directly as it is bundled with your code
class Node {
    constructor(val) {
        this.value = val
        this.left = null
        this.right = null
    }
}

/**
 * @param {Node} root
 * @return {string}
 */

function serialize(root) {
    if (!root) return "";
    let res = [root.value];

    let q = [root];
    while (q.length) {
        let poll = q.shift();

        if (poll.left || poll.right) {
            res.push(poll.left?.value || "null");
            res.push(poll.right?.value || "null");
        }

        if (poll.left) q.push(poll.left)
        if (poll.right) q.push(poll.right)
    }

    return res.join(",");
}

/**
 * @param {string} str
 * @return {Node}
 */
function deserialize(str) {
    if (!str) return null;

    const arr = str.split(",");
    const length = arr.length;

    function buildTree(nodeIdx) {
        if ((nodeIdx >= length) || (arr[nodeIdx] === "null")) return null;

        const node = new Node(arr[nodeIdx]);
        node.left = buildTree(2 * nodeIdx + 1); // leftChildIdx = 2*nodeIdx + 1
        node.right = buildTree(2 * nodeIdx + 2); // rightChildIdx = 2*nodeIdx + 2

        return node;
    }

    return buildTree(0);
}


const tree1 = '1,2,3,4,null,null,5,6,7,null,8,null,null,null,9';
const tree2 = '1,2,3,4,null,null,5,6,7,8,null,null,null,null,9';

const root1 = deserialize(tree1);
const root2 = deserialize(tree2);
console.log(root1);
console.log(root2);

const str1 = serialize(root1);
const str2 = serialize(root2);
console.log(str1);
console.log(str2);

console.log(str1 === tree1)//.toBe(true)
console.log(str2 === tree2)//.toBe(true)