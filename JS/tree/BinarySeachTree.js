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

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
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

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
    delete(node, toDelete) {
        if ([null, undefined].includes(toDelete)) return node;

        if (!node) return node;

        if (toDelete > node.val) node.right = this.delete(node.right, toDelete)
        else if (toDelete < node.val) node.left = this.delete(node.left, toDelete)
        else if (toDelete === node.val) {
            if (!node.left && !node.right) { // the node we want to delete have no children
                node = null;
            } else if (!node.left) { // have only right node
                let temp = node;
                node = node.right;
                temp = null;
            } else if (!node.right) { // have only left node
                let temp = node;
                node = node.left;
                temp = null;
            } else { // have both left, right nodes
                const minInRight = this.findMin(node.right); // to get minimum from right side
                node.val = minInRight.val;
                node.right = this.delete(node.right, minInRight.val);
            }
        } else {
            // toDelete not found
        }

        return node;
    }

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
    search(node, toSearch) {
        if (!node) return false;

        if (node.val === toSearch) return true;
        else if (toSearch > node.val) {
            return this.search(node.right, toSearch);
        } else if (toSearch < node.val) {
            return this.search(node.left, toSearch);
        }
    }

    /* O(n) */
    inOrder(node) {
        let str = "";

        // recursive
        function inOrderUtil(node) {
            if (!node) return;

            inOrderUtil(node.left);
            str += (node.val + " ");
            inOrderUtil(node.right);
        }
        inOrderUtil(node);

        // iterative
        let stack = [], curr = node;
        while (stack.length || curr) {
            while (curr) {
                stack.push(curr);
                curr = curr.left;
            }
            // curr will be null now

            curr = stack.pop();

            str += (curr.val + " ");

            curr = curr.right;
        }

        console.log("inOrder:", str)
    }

    /* O(n) */
    preOrder(node) { // root is found at the end in preOrder traversal
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

    /* O(n) */
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

    /* O(n) */
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

    /* O(n) */
    printByLevel(node) {
        if (!node) return;

        // let q = [{ node, level: 0 }], nodesByLevel = {};
        // while (q.length) { // while queue is not empty
        //     let { node, level } = q.shift(); // removed 1st element from array 
        //     nodesByLevel[level] ? nodesByLevel[level].push(node.val) : nodesByLevel[level] = [node.val];

        //     if (node.left) q.push({ node: node.left, level: level + 1 });
        //     if (node.right) q.push({ node: node.right, level: level + 1 });
        // }

        // console.log(`printByLevel:`, nodesByLevel);


        let q = [node], str = "";
        while (q.length) {
            let size = q.length;
            while (size--) {
                let front = q.shift();

                str += (front.val + " ");

                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);
            }
            str += "\n";
        }

        console.log(`printByLevel:\n`, str);
    }

    /* O(n) */
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

    /* O(n) */
    printDiagonally(node) {
        if (!node) return;

        let str = "\n";

        let q = [node];
        while (q.length) {
            let size = q.length;

            while (size--) {
                let front = q.shift();

                while (front) {
                    str += (front.val + " ");

                    if (front.right) q.push(front.right);
                    front = front.left;
                }
            }

            str += '\n'
        }

        console.log("printDiagonally:", str)
    }

    /* O(n) */
    printSpiral(node) {
        if (!node) return;

        let str = "";

        let stack1 = [], stack2 = [], flag = true;

        if (node) stack1.push(node);

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

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
    findMin(node) {
        if (!node) return;

        let curr = node;
        while (curr.left) curr = curr.left;

        return curr;
    }

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
    findMax(node) {
        if (!node) return;

        let curr = node;
        while (curr.right) curr = curr.right;

        return curr;
    }

    /* avg: O(logn), worst: O(n) */
    getHeight(node) {
        if (!node) return 0;

        let leftHeight = this.getHeight(node.left);
        let rightHeight = this.getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /* O(n) */
    getMaxWidth(node) {
        if (!node) return null;

        let q = [node], maxwidth = 0;
        while (q.length) {
            let size = q.length;
            maxwidth = Math.max(size, maxwidth);

            while (size--) {
                let front = q.shift();
                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);
            }
        }

        return maxwidth;
    }

    /* O(n) */
    getMaxLevelSum(node) {
        if (!node) return;

        let q = [node], maxSum = 0;
        while (q.length) {
            let size = q.length;

            let sum = 0;
            while (size--) {
                let front = q.shift();
                sum += front.val;

                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /* O(n) */
    getMaxDiagonalSum(node) {
        if (!node) return;

        let q = [node], maxSum = 0;
        while (q.length) {
            let size = q.length;
            let sum = 0;

            while (size--) {
                let front = q.shift();
                while (front) {
                    sum += front.val;

                    if (front.right) q.push(front.right);
                    front = front.left;
                }
            }
            maxSum = Math.max(maxSum, sum)
        }

        return maxSum;
    }

    /* O(n) */
    getMaxRootToLeafSum(node) {
        if (!node) return 0;

        if (!node.left && !node.right) return node.val;

        let leftSum = this.getMaxRootToLeafSum(node.left);
        let rightSum = this.getMaxRootToLeafSum(node.right);

        return Math.max(leftSum, rightSum) + node.val;
    }

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
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

    /* O(h), h: height of the tree i.e. root to the deepest leaf node, O(h) can be O(N) too if all the nodes are in one side of the tree */
    inOrderSuccessor(node, no, succ) {
        if (!node) return;

        this.inOrderSuccessor(node.left, no, succ);

        if ((node.val > no) && (succ.left == null)) {
            succ.left = node;
            return;
        }

        this.inOrderSuccessor(node.right, no, succ);
    }

    /* O(n) */
    createMirror(node) {
        if (!node) return;

        // let left = this.createMirror(node.left);
        // let right = this.createMirror(node.right);

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

    /* O(n) */
    rightView(node) {
        if (!node) return;

        let q = [node], str = "";
        while (q.length) {
            let size = q.length;

            while (size) {
                let front = q.shift();

                if (size === 1) str += (front.val + " ");

                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);

                size--;
            }
        }

        console.log("rightView:", str);
    }

    /* O(n) */
    leftView(node) {
        if (!node) return;

        let q = [node], str = "";
        while (q.length) {
            let size = q.length, c = 0;

            while (size) {
                let front = q.shift();

                if (c === 0) str += (front.val + " ");

                if (front.left) q.push(front.left);
                if (front.right) q.push(front.right);

                size--;
                c++;
            }
        }

        console.log("leftView:", str);
    }

    /* O(n) */
    bottomView(node) {
        if (!node) return;

        let q = [{ node, dist: 0 }], distToNodeMap = {};
        while (q.length) {
            let { node: front, dist } = q.shift();

            distToNodeMap[dist] = front.val;

            if (front.left) q.push({ node: front.left, dist: dist - 1 });
            if (front.right) q.push({ node: front.right, dist: dist + 1 });
        }

        let distToNodeMapArr = Object.keys(distToNodeMap).sort((a, b) => a - b).map((key) => distToNodeMap[key]);
        console.log("bottomView:", distToNodeMapArr)
    }

    /* O(n) */
    topView(node) {
        if (!node) return;

        let q = [{ node, dist: 0 }], distToNodeMap = {};
        while (q.length) {
            let { node: front, dist } = q.shift();

            if (!distToNodeMap.hasOwnProperty(dist)) distToNodeMap[dist] = front.val;

            if (front.left) q.push({ node: front.left, dist: dist - 1 });
            if (front.right) q.push({ node: front.right, dist: dist + 1 });
        }

        let distToNodeMapArr = Object.keys(distToNodeMap).sort((a, b) => a - b).map((key) => distToNodeMap[key]);
        console.log("bottomView:", distToNodeMapArr)
    }

    /* O(n) */
    boundaryView(node) {
        if (!node) return;

        const boundarySet = new Set();

        const rightBoundary = (node) => {
            if (!node) return;

            if (node.right) rightBoundary(node.right);
            else if (node.left) rightBoundary(node.left);

            if (!this.isLeaf(node)) boundarySet.add(node.val);
        }

        const leftBoundary = (node) => {
            if (!node) return;

            if (!this.isLeaf(node)) boundarySet.add(node.val);

            if (node.left) leftBoundary(node.left);
            else if (node.right) leftBoundary(node.right);
        }

        const bottomBoundary = (node) => {
            if (!node) return;

            bottomBoundary(node.left);

            if (this.isLeaf(node)) {
                boundarySet.add(node.val);
                return;
            }

            bottomBoundary(node.right);
        }

        leftBoundary(node);
        bottomBoundary(node);
        rightBoundary(node);

        console.log("boundaryView:", boundarySet)
    }

    /* O(1) */
    isLeaf(node) {
        if (node.left === null && node.right === null) return true;
        return false;
    }

    /* O(n) */
    isSymmetric(node) {
        if (!node) return false;

        return isMirror(node.left, node.right);
    }

    /* O(n) */
    isMirror(tree1, tree2) {
        if (!tree1 && !tree2) return true;

        if (!tree1 || !tree2) return false;

        return (tree1.val === tree2.val && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left));
    }

    /* O(n) */
    isValidBST(node) {
        // time: O(n), space: O(h), because of function call stack
        // function checkBST(root, min, max) {
        //     if (!root) return true;

        //     console.log(root.val, min, max);

        //     if ((root.val < min) || (root.val > max)) return false;
        //     return checkBST(root.left, min, root.val - 1) && checkBST(root.right, root.val + 1, max)
        // }
        // return checkBST(node, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);


        // time: O(n), space: O(h), because of function call stack
        let prev = null, isBST = true;
        function inOrderHelper(root) {
            if (!root) return;

            if (isBST) inOrderHelper(root.left); // we will stop recursion if we already found that this tree is not BST

            if (![null, undefined].includes(prev) && prev >= root.val) isBST = false; // in order traversal prev value is always less than this value
            prev = root.val;

            if (isBST) inOrderHelper(root.right); // we will stop recursion if we already found that this tree is not BST
        }
        inOrderHelper(node);

        return isBST;
    }
}

/* O(n) */
function preOrderToPostOrderOfBTButNotBST(preOrder, inOrder) {
    /*
        let preOrder = [1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7];
        let inOrder = [8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7];

        first element of the preOrder traversal is always root
        then we will find the index of the root in inOrder traversal (say it rootIndexInInOrder)
        and in inOrder traversal, left side of the root is left subtree and right side of the root is right subtree

        now we will divide the preOrder and inOrder traversal into left and right subtree and call the same function recursively
        and print the root at the end

        // left subtree:
        preOrder: index 1 to n
        inOrder: index 0 to rootIndexInInOrder - 1

        // right subtree
        preOrder: index rootIndexInInOrder + 1 to n
        inOrder: index rootIndexInInOrder + 1 to n
    */

    let postOrder = [];
    function preOrderToPostOrderOfBT(preOrder, inOrder) {
        const n = inOrder.length;
        const root = preOrder[0];
        const rootIndexInInOrder = inOrder.indexOf(root);

        if (rootIndexInInOrder !== 0) preOrderToPostOrderOfBT(preOrder.slice(1, n), inOrder.slice(0, rootIndexInInOrder));
        if (rootIndexInInOrder !== n - 1) preOrderToPostOrderOfBT(preOrder.slice(rootIndexInInOrder + 1, n), inOrder.slice(rootIndexInInOrder + 1, n));

        postOrder.push(root)
    }
    preOrderToPostOrderOfBT(preOrder, inOrder);

    console.log("preOrderToPostOrderOfBTButNotBST:", postOrder);
}

/* O(n) */
function binaryTreeFromPreAndInOrder(preorder, inorder) {
    if (!preorder || !inorder || !preorder.length || !inorder.length) return null;

    const root = preorder[0];
    const rootNode = new TreeNode(root);
    const indexOfRootInInOrder = inorder.indexOf(root);

    rootNode.left = buildTree(preorder.slice(1), inorder.slice(0, indexOfRootInInOrder));
    rootNode.right = buildTree(preorder.slice(indexOfRootInInOrder + 1), inorder.slice(indexOfRootInInOrder + 1));
    return rootNode;
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

bst.inOrder(bst.root);

// bst.preOrder(bst.root);
// bst.inOrder(bst.root);
// bst.postOrder(bst.root);

// bst.delete(bst.root, 109);

// const isFound = bst.search(bst.root, 115);
// console.log("isFound", isFound)

// bst.levelOrder(bst.root);
bst.printByLevel(bst.root);
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

// bst.createMirror(bst.root)

// bst.boundaryView(bst.root);

// const isValid = bst.isValidBST(bst.root);
// console.log("isValid", isValid)

// let preOrder = [1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7];
// let inOrder = [8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7];
// preOrderToPostOrderOfBTButNotBST(preOrder, inOrder);


// let inOrderArr = [7, 9, 10, 15, 40, 59, 60, 100, 105, 108, 109, 110];
// const node = inOrderArrToBST(inOrderArr);
// bst.inOrder(node);