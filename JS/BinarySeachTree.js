Array.prototype.isEmpty = function() {
    return this.length == 0;
}

class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    insert(node, value) {
        if (!node) {
            node = new Node(value);
            return;
        }

        if (value > node.value) {
            if (!node.right) {
                node.right = new Node(value);
            } else {
                this.insert(node.right, value)
            }
        } else {
            if (!node.left) {
                node.left = new Node(value);
            } else {
                this.insert(node.left, value)
            }
        }
    }

    deleteNode(node, toDelete) {
        if (!node) return;

        if (toDelete > node.value) {
            node.right = this.deleteNode(node.right, toDelete);
        } else if (toDelete < node.value) {
            node.left = this.deleteNode(node.left, toDelete);
        } else {
            if (!node.left && !node.right) {
                //the node we want to delete have no children
                node = null;
            } else if (!node.left) {
                //have only right node
                let temp = node;
                node = node.right;

                temp = null;
            } else if (!node.right) {
                //have only left node
                let temp = node;
                node = node.left;

                temp = null;
            } else {
                //have both left, right nodes
                let min = this.findMinNode(node.right); //storing min value from right side of the sub-tree
                node.value = min.value; //making value of this node as min node

                node.right = this.deleteNode(node.right, min.value); // deleting that duplicate node from the right subtree of this node
            }
        }

        return node;
    }

    search(node, toSearch) {
        if (!node) return null;

        if (node.value == toSearch) {
            return node;
        } else if (toSearch > node.value) {
            return this.search(node.right, toSearch)
        } else {
            return this.search(node.left, toSearch)
        }
    }

    contains(node, toSearch) {
        if (!node) return false;

        if (toSearch == node.value) {
            return true
        } else if (toSearch > node.value) {
            return this.contains(node.right, toSearch)
        } else {
            return this.contains(node.left, toSearch)
        }
    }

    inOrder(node) {
        if (!node) return;

        this.inOrder(node.left);
    
        console.log(node.value)

        this.inOrder(node.right);
    }

    preOrder(node) {
        if (!node) return;

        console.log(node.value)
        
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    postOrder(node) {
        if (!node) return;
        
        this.postOrder(node.left);
        this.postOrder(node.right);

        console.log(node.value)
    }

    levelOrder(node) {
        if (!node) return;
        
        let queue = [];

        let curr = node;
        queue.push(curr);

        let levelOrderStr = "";
        while (!queue.isEmpty()) {
            let front = queue.shift(); //shift works as poll

            levelOrderStr += `${front.value} -> `;

            if (front.left) queue.push(front.left);
            if (front.right) queue.push(front.right);
        }

        levelOrderStr = levelOrderStr.substring(0, levelOrderStr.length - 4); // for removing last ->
        console.log("levelOrderStr", levelOrderStr);
    }

    printByLevel(node, targetLevel) {
        if (!node) return;
        
        let queue = [];

        let curr = node;
        queue.push({ node: curr, level: 0});

        let levelOrderStr = "";
        while (!queue.isEmpty()) {
            let { node, level } = queue.shift() || {}; //shift works as poll

            if (level === targetLevel) {
                levelOrderStr += `${node.value}, `;
            }

            if (node.left && (level + 1 <= targetLevel)) queue.push({ node: node.left, level: level +1 });
            if (node.right && (level + 1 <= targetLevel)) queue.push({ node: node.right, level: level +1 });
        }

        levelOrderStr = levelOrderStr.substring(0, levelOrderStr.length - 2); // for removing last ->
        console.log("levelOrderStr", levelOrderStr);
    }

    printSpiral(node) {
        if (!node) return;

        let stack0 = [];
        let stack = [];
        stack.push(node);
        
        let printSpiralStr = "";
        let flag = true;
        while (!stack0.isEmpty() || !stack.isEmpty()) {
            if (flag) {
                while (!stack.isEmpty()) {
                    let top = stack.pop();

                    printSpiralStr += `${top.value} -> `;

                    if (top.left) stack0.push(top.left);
                    if (top.right) stack0.push(top.right);
                }
            } else {
                while (!stack0.isEmpty()) {
                    let top = stack0.pop();

                    printSpiralStr += `${top.value} -> `;

                    if (top.right) stack.push(top.right);
                    if (top.left) stack.push(top.left);
                }
            }

            flag = !flag;
        }

        printSpiralStr = printSpiralStr.substring(0, printSpiralStr.length - 4); // for removing last ->
        console.log("printSpiral", printSpiralStr);
    }

    printDiagonally(node) {
        if (!node) return;

        let queue = [];
        queue.push(node);
        while (!queue.isEmpty()) {
            let size = queue.length;

            let diagonal = "";
            while (size > 0) {
                let front = queue.shift();

                while (front) {
                    if (front.right) queue.push(front.right);

                    diagonal += (front.value + " -> ");
                    front = front.left;
                }

                size--;
            }
            diagonal = diagonal.substring(0, diagonal.length - 4)
            console.log(diagonal);
        }
    }

    printVertically(node) {
        if (!node) return;
        
        let distToNodeMap = {};

        let queue = [];
        queue.push({ node, dist: 0 });
        while (!queue.isEmpty()) {
            let { node: top, dist} = queue.shift() || {};

            distToNodeMap[dist] = distToNodeMap[dist] ? [ ...distToNodeMap[dist], top.value ] : [ top.value ];
            if (top.left) queue.push({ node: top.left, dist: dist - 1 });
            if (top.right) queue.push({ node: top.right, dist: dist + 1 });
        }

        const distToNodeMapArr =  Object.keys(distToNodeMap).sort().map((key) => distToNodeMap[key]);
        console.log("distToNodeMapArr", distToNodeMapArr)
    }

    findMinNode(node) {
        if (!node) return;

        let temp = node;
        while (temp.left) {
            temp = temp.left;
        }

        return temp;
    }

    findMin(node) {
        if (!node) return;

        let curr = node;
        while (curr.left) {
            curr = curr.left;
        }

        console.log("min", curr.value)
    }

    findMax(node) {
        if (!node) return;

        let curr = node;
        while (curr.right) {
            curr = curr.right;
        }

        console.log("max", curr.value)
    }

    getHeight(node) {
        if (!node) return 0;

        let leftHeight = this.getHeight(node.left);
        let rightHeight = this.getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1
    }

    getMaxWidth(node) {
        if (!node) return 0;
        
        let maxWidth = 0;
        let queue = [];
        queue.push(node);
        while (!queue.isEmpty()) {
            let size = queue.length;
            maxWidth = Math.max(size, maxWidth);

            while (size) {
                let top = queue.shift(); //poll
                
                if (top.left) queue.push(top.left);
                if (top.right) queue.push(top.right);

                size--;
            }
        }

        return maxWidth;
    }

    getMaxLevelSum(node) {
        if (!node) return;

        let queue = [];
        queue.push(node);

        let maxSum = 0;
        while (!queue.isEmpty()) {
            let size = queue.length;

            let sum = 0;
            while (size > 0) {
                let front = queue.shift();

                sum += front.value;

                if (front.left) queue.push(front.left);
                if (front.right) queue.push(front.right);

                size--;
            }
            maxSum = Math.max(maxSum, sum)
        }

        return maxSum;
    }

    maxDiagonalSum(node) {
        if (!node) return;

        let maxDiagSum = 0;

        let queue = [];
        queue.push(node);
        while (!queue.isEmpty()) {
            let size = queue.length;

            let diagonalSum = 0;
            while (size > 0) {
                let front = queue.shift();

                while (front) {
                    if (front.right) queue.push(front.right);

                    diagonalSum += parseInt(front.value);
                    front = front.left;
                }

                size--;
            }

            maxDiagSum = Math.max(maxDiagSum, diagonalSum)
            console.log(diagonalSum);
        }

        return maxDiagSum;
    }

    rootToLeafSum(node) {
        if (!node) return 0;

        if (!node.left && !node.right) return node.value;

        return node.value + this.rootToLeafSum(node.left) + this.rootToLeafSum(node.right)
    }

    //LCA
    lowestCommonAncestor(node, n1, n2) {
        if (!node) return null;

        if (n1 > node.value && n2 > node.value) {
            return this.lowestCommonAncestor(node.right, n1, n2)
        } else if (n1 < node.value && n2 < node.value) {
            return this.lowestCommonAncestor(node.left, n1, n2)
        } {
            return node;
        }
    }

    inOrderSuccessor(node, no, succ) {
        if (!node) return;

        this.inOrderSuccessor(node.left, no, succ);
        
        if ((node.value > no) && (succ.left == null)) {
            succ.left = node;
            return;
        }

        this.inOrderSuccessor(node.right, no, succ);
    }

    mirror(node) {
        if (!node) return;

        let left = node.left;
        node.left = node.right;
        this.mirror(node.left);

        node.right = left;
        this.mirror(node.right);
    }

    rightView(node) {
        //print the rightmost node of the tree at each level
        if (!node) return;

        let queue = [];
        queue.push(node);

        let rightViewStr = "";
        while (!queue.isEmpty()) {
            let size = queue.length;

            while (size > 0) {
                let front = queue.shift();

                if (size == 1) rightViewStr += (front.value + ", ");

                if (front.left) queue.push(front.left);
                if (front.right) queue.push(front.right);

                size--;
            }
        }

        rightViewStr = rightViewStr.substring(0, rightViewStr.length-2);
        return rightViewStr;
    }

    leftView(node) {
        //print the leftmost node of the tree at each level
        if (!node) return;

        let queue = [];
        queue.push(node);

        let leftViewStr = "";
        while (!queue.isEmpty()) {
            let size = queue.length;

            while (size > 0) {
                let front = queue.shift();

                if (size == 1) leftViewStr += (front.value + ", ");

                if (front.right) queue.push(front.right);
                if (front.left) queue.push(front.left);

                size--;
            }
        }

        leftViewStr = leftViewStr.substring(0, leftViewStr.length-2);
        return leftViewStr;
    }

    bottomView(node) {
        //print the bottommost node of the tree at each dist (horizontal distance from root)
        if (!node) return;

        let distToNodeMap = {};

        let queue = [];
        queue.push({ node, dist: 0 });

        while (!queue.isEmpty()) {
            let { node: front, dist } = queue.shift();

            distToNodeMap[dist] = front.value;

            if (front.left) queue.push({ node: front.left, dist: dist + 1 });
            if (front.right) queue.push({ node: front.right, dist: dist - 1 });
        }

        let distToNodeMapArr = Object.keys(distToNodeMap).sort((a, b) => a-b).map((key) => distToNodeMap[key]);
        console.log("distToNodeMapArr", distToNodeMapArr)
    }

    topView(node) {
        //print the bottommost node of the tree at each dist (horizontal distance from root)
        if (!node) return;

        let distToNodeMap = {};

        let queue = [];
        queue.push({ node, dist: 0 });

        while (!queue.isEmpty()) {
            let { node: front, dist } = queue.shift();

            distToNodeMap[dist] = distToNodeMap[dist] >=0 ? distToNodeMap[dist] : front.value;

            if (front.left) queue.push({ node: front.left, dist: dist + 1 });
            if (front.right) queue.push({ node: front.right, dist: dist - 1 });
        }

        let distToNodeMapArr = Object.keys(distToNodeMap).sort((a, b) => a-b).map((key) => distToNodeMap[key]);
        console.log("distToNodeMapArr", distToNodeMapArr)
    }

    //boundary traversal
    boundarySet = new Set();
    boundaryView(node) {
        if (!root) return

        this.rightBoundary(node);
        this.leftBoundary(node);
        this.bottomBoundary(node);

        console.log("boundarySet", this.boundarySet)
    }

    leftBoundary(root) {
		if (!root) return

        this.boundarySet.add(root.value);
        
        if (root.left) {
            this.leftBoundary(root.left);
        } else if (root.right) {
            this.leftBoundary(root.right);
        }
	}

    rightBoundary(root) {
		if (!root) return
        
        if (root.right) {
            this.rightBoundary(root.right);
        } else if (root.left) {
            this.rightBoundary(root.left);
        }

        this.boundarySet.add(root.value);
	}

    bottomBoundary(root) {
		if (!root) return
        
        this.bottomBoundary(root.left);
        
        if (!root.right && !root.left) { 
            this.boundarySet.add(root.value);
        }

        this.bottomBoundary(root.right);
	}

    preOrderToPostOrder(preOrder, inOrder) {
        console.log("inOrder", inOrder)
        console.log("preOrder", preOrder)

        let root = preOrder[0];
        let rootIndexInInOrder = inOrder.indexOf(root);
        let n = inOrder.length;

        if (rootIndexInInOrder != 0)
            this.preOrderToPostOrder(preOrder.slice(1, n), inOrder.slice(0, rootIndexInInOrder));
        
        if (rootIndexInInOrder != n - 1)
            this.preOrderToPostOrder(preOrder.splice(rootIndexInInOrder + 1, n), inOrder.splice(rootIndexInInOrder + 1, n));

        console.log(root);
    }
}

let tree = new Tree();
let root = new Node(54);
tree.insert(root, 10);
tree.insert(root, 70);
tree.insert(root, 63);
tree.insert(root, 80);
tree.insert(root, 1);
tree.insert(root, 11);
tree.insert(root, 45);
tree.insert(root, 0);
tree.insert(root, 9);
tree.insert(root, 5);
tree.insert(root, -2);
tree.insert(root, -1);
tree.insert(root, 30);

// tree.deleteNode(root, 1);
// console.log("root", root)

// const foundInNode = tree.search(root, 80);
// console.log("foundInNode", foundInNode)

// let toSearch = 11;
// const contains = tree.contains(root, toSearch);
// console.log("contains " + toSearch, contains)

// tree.inOrder(root)

// tree.printByLevel(root, -4);
// tree.printSpiral(root);
// tree.printDiagonally(root);

// tree.findMax(root);

// const height = tree.getHeight(root);
// console.log("height", height)

// let maxWidth = tree.getMaxWidth(root);
// console.log("maxWidth", maxWidth)

// let maxLevSum = tree.getMaxLevelSum(root);
// console.log("maxLevSum", maxLevSum);

// let maxDiagSum = tree.maxDiagonalSum(root);
// console.log("maxDiagSum", maxDiagSum)

// let rootToLeafSumVal = tree.rootToLeafSum(root.left)
// console.log("rootToLeafSumVal", rootToLeafSumVal)

// let lca = tree.lowestCommonAncestor(root, 0, 5)
// console.log("lowestCommonAncestor", lca.value)

// let succ = new Node(-1234)
// let inOrderSucc = tree.inOrderSuccessor(root, 19, succ);
// console.log("inOrderSucc", succ.left.value)

// tree.mirror(root);
// tree.inOrder(root);

// let leftViewStr = tree.leftView(root);
// console.log("leftViewStr", leftViewStr)

// tree.topView(root)
// tree.boundaryView(root)

let preOrder = [1, 2, 4, 5, 3, 6];
let inOrder = [4, 2, 5, 1, 3, 6];

tree.preOrderToPostOrder(preOrder, inOrder)