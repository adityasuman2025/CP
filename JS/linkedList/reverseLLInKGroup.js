/*
https://leetcode.com/problems/reverse-nodes-in-k-group/

25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
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
 * @param {number} k
 * @return {ListNode}
*/
var reverseKGroup = function(head, k) {
    if (!head) return head;
    
    let temp = head, size = 0;
    while (temp) {
        temp = temp.next;
        size++;
    }
    if (k>size) return head;
    
    let curr = head;
    let prev = null, next = null;
    
    let i = 0;
    while (i<k && curr) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        
        curr = next;
        i++;
    }
    
    head.next = reverseKGroup(curr, k)
    
    return prev;
};