/*
https://leetcode.com/problems/min-stack/

155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

const Node = function(value, min) {
    this.value = value; //function constructor
    this.minTillThis = min; //function constructor
    this.next = null; //function constructor
}

// class Node {
//     constructor(value, min) {
//         this.value = value;
//         this.minTillThis = min;
//         this.next = null;
//     }
// }

const MinStack = function() {
    this.head = null;
    this.tail = null;
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    if (!this.head) {
        this.head = new Node(val, val);
        this.tail = this.head;
    } else {
        let minTillThis = this.tail.minTillThis;
        this.tail.next = new Node(val, Math.min(val, minTillThis));
        this.tail = this.tail.next;
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    if (!this.head) {
        return null;
    } else {
        if (!this.head.next) {
            // stack has only 1 element
            this.head = null;
            this.tail = null;
            return;
        }
        
        let curr = this.head;
        let prev = null;
        while (curr.next) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        this.tail = prev;
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    if (!this.head) {
        return null;
    } else {
        return this.tail.value;
    }
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    if (!this.head) {
        return null;
    } else {
        return this.tail.minTillThis;
    }
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */