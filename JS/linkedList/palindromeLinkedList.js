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

// time: 0(n), space: O(1)
var isPalindrome = function(head) {
    // finding center/middle of the list
    let slow = head, fast = head.next;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }


    // reversing the 2nd half
    let mid = slow;
    let prev = null, curr = mid.next;
    mid.next = null; // breaking 1st half from 2nd half

    while (curr) {
        let next = curr.next;
        curr.next = prev;
        prev = curr;

        curr = next;
    }
    mid.next = prev; // joining 1st half with reversed 2nd half


    // checking palindrome
    let curr1 = head, curr2 = mid.next;
    while (curr1 && curr2) {
        if (curr1.val !== curr2.val) return false;
        curr1 = curr1.next;
        curr2 = curr2.next;
    }

    return true;
};
