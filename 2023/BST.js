// heap after this

class Node {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BST {
    constructor() {
        this.root = null;
    }

    /*
        In a balanced BST, the height is approximately log₂(n), where n is the number of nodes in the tree. 
        This is because at each level of a balanced binary tree, the number of nodes roughly doubles.
        As a result, the time complexity of finding the maximum value in a balanced BST is O(log n).

        However, in the worst case scenario, the BST can become skewed, meaning all nodes are in a single branch.
        In this case, the height of the tree becomes n - 1 (essentially a linked list), and the time complexity of finding the maximum value becomes O(n), as you would need to traverse all nodes in the skewed tree.


        In summary O(h) is,
        In Average case (balanced BST): O(log n)
        In Worst case (skewed BST): O(n)
    */

    // O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree
    insert(val) {
        if ([null, undefined].includes(val)) return;

        if (!this.root) this.root = new Node(val);
        else insertUil(this.root, val);

        function insertUil(node, val) {
            if (val > node.val) {
                if (node.right) insertUil(node.right, val);
                else node.right = new Node(val);
            } else {
                if (node.left) insertUil(node.left, val);
                else node.left = new Node(val);
            }
        }
    }

    // O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree
    delete(node, toDelete) {
        if ([null, undefined].includes(toDelete)) return;

        if (!node) return;

        if (toDelete > node.val) node.right = this.delete(node.right, toDelete)
        else if (toDelete < node.val) node.left = this.delete(node.left, toDelete)
        else { // toDelete === node.val
            if (!node.left && !node.right) { // the node we want to delete have no children
                node = null;
            } else if (!node.left) { // have only right node
                let temp = node;
                node = node.right;
                temp = null;
            } else if (!node.right) {// have only left node
                let temp = node;
                node = node.left;
                temp = null;
            } else { // have both left, right nodes
                const minInRight = this.findMin(node.right); // to get minimum from right side
                node.val = minInRight.val;
                node.right = this.delete(node.right, minInRight.val);
            }
        }

        return node;
    }

    // O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree
    search(node, toSearch) {
        if (!node) return false;

        if (node.val === toSearch) return true;
        else if (toSearch > node.val) {
            return this.search(node.right, toSearch);
        } else if (toSearch < node.val) {
            return this.search(node.left, toSearch);
        }
    }

    // O(N)
    inOrder(node) {
        let str = "";
        function inOrderUtil(node) {
            if (!node) return;

            inOrderUtil(node.left);
            str += (node.val + " ");
            inOrderUtil(node.right);
        }
        inOrderUtil(node);

        console.log("inOrder:", str)
    }

    // O(N)
    preOrder(node) {
        let str = "";
        function preOrderUtil(node) {
            if (!node) return;

            str += (node.val + " ");
            preOrderUtil(node.left);
            preOrderUtil(node.right);
        }
        preOrderUtil(node);

        console.log("preOrder:", str)
    }

    // O(N)
    postOrder(node) { // root is found at the end in postOrder traversal
        let str = "";
        function postOrderUtil(node) {
            if (!node) return;

            postOrderUtil(node.left);
            postOrderUtil(node.right);
            str += (node.val + " ");
        }
        postOrderUtil(node);

        console.log("postOrder:", str)
    }

    // O(N)
    levelOrder(node) {
        if (!node) return;

        let q = [node], str = "";
        while (q.length) { // while queue is not empty
            let front = q.shift(); // removed 1st element from array 
            str += (front.val + " ");

            if (front.left) q.push(front.left);
            if (front.right) q.push(front.right);
        }

        console.log("levelOrder:", str)
    }

    // O(N)
    printByLevel(node) {
        if (!node) return;

        let q = [{ node, level: 0 }], nodesByLevel = {};
        while (q.length) { // while queue is not empty
            let { node, level } = q.shift(); // removed 1st element from array 
            nodesByLevel[level] ? nodesByLevel[level].push(node.val) : nodesByLevel[level] = [node.val];

            if (node.left) q.push({ node: node.left, level: level + 1 });
            if (node.right) q.push({ node: node.right, level: level + 1 });
        }

        console.log(`printByLevel:`, nodesByLevel);


        // let q = [node], str = "";
        // while (q.length) {
        //     let size = q.length;
        //     while (size) {
        //         let front = q.shift();

        //         str += (front.val + " ");

        //         if (front.left) q.push(front.left);
        //         if (front.right) q.push(front.right);

        //         size--;
        //     }
        //     str += "\n";
        // }

        // console.log(`printByLevel:`, str);
    }

    // O(N)
    printVertically(node) {
        if (!node) return;

        let q = [{ node, dist: 0 }], nodesByDist = {};
        while (q.length) {
            const { node, dist } = q.shift();

            nodesByDist[dist] ? nodesByDist[dist].push(node.val) : nodesByDist[dist] = [node.val];

            if (node.left) q.push({ node: node.left, dist: dist - 1 });
            if (node.right) q.push({ node: node.right, dist: dist + 1 });
        }

        const res = Object.keys(nodesByDist).sort((a, b) => a - b).map((key) => nodesByDist[key]);
        console.log("printVertically:", res)
    }

    // O(N)
    printDiagonally(node) {
        if (!node) return;

        let str = "\n";

        let q = [node];
        while (q.length) {
            let size = q.length;

            while (size) {
                let front = q.shift();

                while (front) {
                    str += (front.val + " ");

                    if (front.right) q.push(front.right);
                    front = front.left;
                }

                size--;
            }

            str += '\n'
        }

        console.log("printDiagonally:", str)
    }

    // O(N)
    printSpiral(node) {
        if (!node) return;

        let str = "";

        let stack1 = [node], stack2 = [], flag = true;
        while (stack1.length || stack2.length) {
            if (flag) {
                while (stack1.length) {
                    const top = stack1.pop();
                    str += (top.val + " ");

                    if (top.left) stack2.push(top.left);
                    if (top.right) stack2.push(top.right);
                }
            } else {
                while (stack2.length) {
                    const top = stack2.pop();
                    str += (top.val + " ");

                    if (top.right) stack1.push(top.right);
                    if (top.left) stack1.push(top.left);
                }
            }

            flag = !flag;
        }

        console.log("printSpiral:", str);
    }

    // O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree
    findMin(node) {
        if (!node) return;

        let curr = node;
        while (curr.left) curr = curr.left;

        return curr;
    }

    // O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree
    findMax(node) {
        if (!node) return;

        let curr = node;
        while (curr.right) curr = curr.right;

        return curr;
    }

    // avg: O(logN), worst: O(N)
    getHeight(node) {
        if (!node) return 0;

        let leftHeight = this.getHeight(node.left);
        let rightHeight = this.getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // O(N)
    getMaxWidth(node) {
        if (!node) return null;

        let q = [node], maxwidth = 0;
        while (q.length) {
            let size = q.length;
            maxwidth = Math.max(size, maxwidth);

            while (size) {
                let front = q.shift();
                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);

                size--;
            }
        }

        return maxwidth;
    }

    // O(N)
    getMaxLevelSum(node) {
        if (!node) return;

        let q = [node], maxSum = 0;
        while (q.length) {
            let size = q.length;


            let sum = 0;
            while (size) {
                let front = q.shift();
                sum += front.val;

                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);

                size--;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // O(N)
    getMaxDiagonalSum(node) {
        if (!node) return;

        let q = [node], maxSum = 0;
        while (q.length) {
            let size = q.length;
            let sum = 0;

            while (size) {
                let front = q.shift();
                while (front) {
                    sum += front.val;

                    if (front.right) q.push(front.right);
                    front = front.left;
                }
                size--;
            }
            maxSum = Math.max(maxSum, sum)
        }

        return maxSum;
    }

    // O(N)
    getMaxRootToLeafSum(node) {
        if (!node) return 0;

        if (!node.left && !node.right) return node.val;

        let leftSum = this.getMaxRootToLeafSum(node.left);
        let rightSum = this.getMaxRootToLeafSum(node.right);

        return Math.max(leftSum, rightSum) + node.val;
    }

    // O(h)
    lowestCommonAncestor(node, n1, n2) {
        if (!node) return;

        if (n1 > node.val && n2 > node.val) {
            return this.lowestCommonAncestor(node.right, n1, n2);
        } else if (n1 < node.val && n2 < node.val) {
            return this.lowestCommonAncestor(node.left, n1, n2);
        } {
            return node;
        }
    }

    // O(h)
    inOrderSuccessor(node, no, succ) {
        if (!node) return;

        this.inOrderSuccessor(node.left, no, succ);

        if ((node.val > no) && (succ.left == null)) {
            succ.left = node;
            return;
        }

        this.inOrderSuccessor(node.right, no, succ);
    }

    // O(N) // create the mirror tree of the given tree
    mirror(node) {
        if (!node) return;

        // let left = this.mirror(node.left);
        // let right = this.mirror(node.right);

        // node.left = right;
        // node.right = left;

        // return node;

        let q = [node];
        while (q.length) {
            let front = q.shift();

            if (front.left) q.push(front.left);
            if (front.right) q.push(front.right);

            let left = front.left;
            front.left = front.right;
            front.right = left;
        }
    }

    rightView(node) {

    }
}

const bst = new BST();
bst.insert(100);
bst.insert(59);
bst.insert(109);
bst.insert(7);
bst.insert(10);
bst.insert(110);
bst.insert(108);
bst.insert(15);
bst.insert(40);
bst.insert(60);
bst.insert(9);
bst.insert(105);

// bst.inOrder(bst.root);
// bst.preOrder(bst.root);
// bst.postOrder(bst.root);

// bst.delete(bst.root, 109);

// const isFound = bst.search(bst.root, 115);
// console.log("isFound", isFound)

// bst.levelOrder(bst.root);
// bst.printByLevel(bst.root);
// bst.printVertically(bst.root);
// bst.printDiagonally(bst.root);
// bst.printSpiral(bst.root);

// const max = bst.findMax(bst.root);
// console.log("max", max.val);

// const height = bst.getHeight(bst.root);
// console.log("height", height);

// const maxWidth = bst.getMaxWidth(bst.root);
// console.log("maxWidth", maxWidth);

// const maxLevelSum = bst.getMaxLevelSum(bst.root);
// console.log("maxLevelSum", maxLevelSum);

// const maxDiagonalSum = bst.getMaxDiagonalSum(bst.root);
// console.log("maxDiagonalSum", maxDiagonalSum);

// const maxRootToLeafSum = bst.getMaxRootToLeafSum(bst.root);
// console.log("maxRootToLeafSum", maxRootToLeafSum);

// const lca = bst.lowestCommonAncestor(bst.root, 108, 105);
// console.log("lca", lca);

// let succ = new Node(-123);
// bst.inOrderSuccessor(bst.root, 7, succ);
// console.log("inOrderSucc", succ.left.val);

// bst.mirror(bst.root)


bst.inOrder(bst.root);