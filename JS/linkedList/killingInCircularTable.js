/*
https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/

1823. Find the Winner of the Circular Game
There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

The rules of the game are as follows:

Start at the 1st friend.
Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
The last friend you counted leaves the circle and loses the game.
If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.

 

Example 1:


Input: n = 5, k = 2
Output: 3
Explanation: Here are the steps of the game:
1) Start at friend 1.
2) Count 2 friends clockwise, which are friends 1 and 2.
3) Friend 2 leaves the circle. Next start is friend 3.
4) Count 2 friends clockwise, which are friends 3 and 4.
5) Friend 4 leaves the circle. Next start is friend 5.
6) Count 2 friends clockwise, which are friends 5 and 1.
7) Friend 1 leaves the circle. Next start is friend 3.
8) Count 2 friends clockwise, which are friends 3 and 5.
9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
Example 2:

Input: n = 6, k = 5
Output: 1
Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
*/


/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

var findTheWinner = function (n, k) {
    // making the linked list for n items
    let head, temp;
    for (let i = 1; i <= n; i++) {
        if (i === 1) {
            head = new Node(i);
            temp = head;
        } else {
            temp.next = new Node(i);
            temp = temp.next;
        }
    }
    temp.next = head; // joining last element of the linked list to head // because table is circular so linkedlist should be circular

    let size = n, curr = head, prev = head;
    while (size > 1) {
        size--;

        let c = k - 1;
        while (c) {
            prev = curr;
            curr = curr.next;
            c--;
        }

        // deleting the curr element
        prev.next = curr.next;
        curr = curr.next;
    }
    curr.next = null; // only 1 element is left and it is circular to itself, so removing circularity

    return curr.val;
};



// Josephus Problem
var findTheWinner = function (n, k) {
    let i = 1, ans = 0;
    while (i <= n) {
        ans = (ans + k) % i
        i++
    }
    return ans + 1
};