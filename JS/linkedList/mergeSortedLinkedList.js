/*
https://leetcode.com/problems/merge-two-sorted-lists/submissions/

21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/

var mergeTwoLists = function(list1, list2) {
    if(!list1) return list2;
    if(!list2) return list1;
    
    let curr1 = list1;
    let curr2 = list2;
    
    let head = new ListNode(0);
    let curr = head;
    
    while (curr1 && curr2) {
        if (curr1.val <= curr2.val) {
            curr.next = curr1

            curr1 = curr1.next;
        } else {
            curr.next = curr2
            
            curr2 = curr2.next;
        }
        
        curr = curr.next;
    }
    
    while (curr1) {
        curr.next = curr1
        
        curr = curr.next
        curr1 = curr1.next;
    }
    
    while (curr2) {
        curr.next = curr2
        curr = curr.next;
        
        curr2 = curr2.next;
    }
    
    head = head.next
    return head;
};