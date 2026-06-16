/*
https://leetcode.com/problems/odd-even-linked-list/description/
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
*/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function(head) {
    if (!head) return head;

    let oddHead = null, evenHead = null;
    let oddCurr = null, evenCurr = null;

    let i = 1; // starting from 1
    while (head) {
        if (i % 2 == 0) {
            // even
            if (!evenCurr) {
                evenCurr = head;
                evenHead = evenCurr;
            } else {
                evenCurr.next = head;
                evenCurr = evenCurr.next;
            }
        } else {
            // odd
            if (!oddCurr) {
                oddCurr = head;
                oddHead = oddCurr
            } else {
                oddCurr.next = head;
                oddCurr = oddCurr.next;
            }
        }

        i++;
        head = head.next;
    }
    if (evenCurr) evenCurr.next = null;
    if (oddCurr) oddCurr.next = evenHead;

    return oddHead;
};
