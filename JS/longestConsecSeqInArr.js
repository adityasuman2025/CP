/*
https://leetcode.com/problems/longest-consecutive-sequence/

128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

// brute force
const longestConsecutive = function(arr) {
    if (arr.length == 0) return 0;

    arr.sort((a, b) => (a-b));
    
    arr = [...new Set(arr)];
    
    let maxSeqLen = 1, seqLen = 1;
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] == arr[i-1] + 1) {
            seqLen++;
        } else {
            seqLen = 1;
        }
        
        maxSeqLen = Math.max(maxSeqLen, seqLen);
    }
    
    return maxSeqLen;
}

// optimised
const longestConsecutiveOptimised = function(arr) {
    //we are storing array value in set, because array can be too large because of repeated values, which can cause TLE
    const set = new Set(arr);
    
    let maxSeqLen = 0;
    set.forEach(temp => {
        if (!set.has(temp - 1)) {
            let j = temp;
	        while (set.has(j)) j++;
            
            maxSeqLen = Math.max(maxSeqLen, j - temp)
        }
    });
    
    return maxSeqLen;
}