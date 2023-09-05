/*
https://leetcode.com/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75

875. Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
*/


/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function (piles, h) {
    let minBan = 1; // minimum 1 banana should be eaten per hour, otherwise no progress
    let maxBan = Math.max(...piles); // at max, max(piles) bananas are required to be eaten per hour

    let ans = Number.MAX_SAFE_INTEGER;
    while (minBan <= maxBan) {
        let mid = parseInt((minBan + maxBan) / 2);

        let hoursNeededToFinishAtSpeedOfMid = 0;
        for (let i = 0; i < piles.length; i++) {
            hoursNeededToFinishAtSpeedOfMid += Math.ceil(piles[i] / mid); // ceil because if finished earlier then need to take upper bond (GIF: Greatest Integer Function)
        }

        if (hoursNeededToFinishAtSpeedOfMid <= h) {
            ans = Math.min(ans, mid);
            maxBan = mid - 1;
        } else {
            minBan = mid + 1;
        }
    }

    return ans;
};