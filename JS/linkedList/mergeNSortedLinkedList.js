/*
https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1


Flattening a Linked List

Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
For more clarity have a look at the printList() function in the driver code.

 

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)
 

Example 2:

Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)
 

Your Task:
You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.

Expected Time Complexity: O(N*N*M)
Expected Auxiliary Space: O(N)
*/

/*LINKED LIST NODE
class Node {
  constructor(x){
    this.data = x;
    this.next = null;
    this.bottom = null;
  }
}
*/

/**
 * @param {Node} head
 * @return {Node}
*/

class Solution {
    flatten(head) {
        let resHead = null, resCurr = null;

        while (true) {
            // finding the min value element
            let min = Number.MAX_SAFE_INTEGER, minCurr = null;
            let curr = head;
            while (curr) {
                if (curr.data !== 0 && (curr.data < min)) {
                    min = curr.data;
                    minCurr = curr; // minCurr is pointer to point the min value
                }

                curr = curr.next;
            }

            // if no minCurr is found or minCurr.data is 0, means all elements from the linked list has been taken so breaking the infinite loop
            if (!minCurr || minCurr.data === 0) break;

            if (!resCurr) {
                resCurr = new Node(min);
                resHead = resCurr;
            } else {
                resCurr.bottom = new Node(min);
                resCurr = resCurr.bottom;
            }

            // deleting the minCurr pointer's element from the linked list
            if (minCurr.bottom) {
                let data = minCurr.bottom.data;
                minCurr.data = data;

                minCurr.bottom = minCurr.bottom.bottom;
            } else {
                minCurr.data = 0;
            }
        }

        return resHead;
    }
}