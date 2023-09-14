/*
https://leetcode.com/problems/group-anagrams/description/

49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/


/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let res = new Map();

    for (let i=0; i<strs.length; i++) {
        let str = (strs[i].split("")).sort().join("");

        if (res.has(str)) { // if that string is anagram with any other string, then its key (sorted string) will exist in the map
            res.set(str, [...res.get(str), strs[i]]);
        } else {
            res.set(str, [strs[i]]);
        }
    }

    return Array.from(res.values());
};