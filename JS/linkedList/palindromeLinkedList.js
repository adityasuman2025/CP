/*
https://leetcode.com/problems/palindrome-linked-list/

234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
*/

/*
    1. Find middle of list
    2. reverse 2nd half
    3. iterate from head and from mid+1 and compare value . It should match if its palindrome
*/

var isPalindrome = function(head) {
    //Finding middle 
    let slow = head;
    let fast = head;
    let mid = 0;
    while (fast.next && fast.next.next) {
        slow = slow.next;
        fast = fast.next.next;
        mid++;
    }
    
    //Reversing 2nd half
    let curr = slow.next;
    let prev = null;
    let next = null;
    while (curr) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
    
        curr = next;
    }

    slow = prev; //prev pointer is the head of the reversed 2nd half
    // Start comparing node by node now
    while (slow) {
        if (slow.val != head.val) return false;
        head = head.next;
        slow = slow.next
    }
    
    return true;
};
