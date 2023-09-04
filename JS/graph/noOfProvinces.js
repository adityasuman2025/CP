/*
https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75

547. Number of Provinces
Medium
8.9K
326
Companies
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
*/


/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function (arr) {
    let visited = new Set();

    let n = arr.length, c = 0;

    for (let i = 0; i < n; i++) {
        if (!visited.has(i)) {
            c++;
            dfs(i);
        }
    }

    function dfs(city) {
        visited.add(city);

        for (let neighbor = 0; neighbor < arr[city].length; neighbor++) {
            if (arr[city][neighbor] === 1 && !visited.has(neighbor)) {
                dfs(neighbor)
            }
        }
    }

    console.log("visited", visited)

    return c
};