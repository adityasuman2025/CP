/*
https://leetcode.com/problems/evaluate-division/

399. Evaluate Division
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
*/

class Graph {
    constructor() {
        this.adjList = new Map();
    }

    buildGraph(origin, dest, actn) {
        if (!this.adjList.has(origin)) this.adjList.set(origin, []);
        this.adjList.get(origin).push({ node: dest, actn });

        if (!this.adjList.has(dest)) this.adjList.set(dest, []);
        this.adjList.get(dest).push({ node: origin, actn: 1 / actn });
    }

    print() {
        this.adjList.keys().forEach(key => {
            console.log(key, this.adjList.get(key))
        })
    }

    dfs(origin, dest, calc) {
        const visited = new Set();

        if (origin === dest) return this.adjList.get(origin) ? 1 : -1

        const uitl = (origin, dest, calc) => {
            if (origin === dest) return calc;

            const children = this.adjList.get(origin) || [];
            for (let i = 0; i < children.length; i++) {
                const { node, actn } = children[i];

                if (!visited.has(node)) {
                    visited.add(node);
                    const ans = uitl(node, dest, calc * actn)
                    if (ans !== -1) return ans;
                }
            }

            return -1
        }

        visited.add(origin);
        return uitl(origin, dest, 1);
    }
}

/**
 * @param {string[][]} equations
 * @param {number[]} values
 * @param {string[][]} queries
 * @return {number[]}
 */
var calcEquation = function(equations, values, queries) {
    const graph = new Graph();

    equations.forEach(([origin, dest], idx) => {
        graph.buildGraph(origin, dest, values[idx]);
    });

    const ans = [];
    queries.forEach(([origin, dest]) => {
        ans.push(graph.dfs(origin, dest))
    })

    return ans;
};