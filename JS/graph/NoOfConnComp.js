/*
    https://neetcode.io/problems/count-connected-components/question

    Number of Connected Components in an Undirected Graph

    Medium
    Topics
    Company Tags

    Hints
    You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.

    Return the number of connected components in the graph.

    Example 1:



    Input:
    n = 5, edges = [[0,1],[1,2],[3,4]]

    Output: 2
    Example 2:



    Input:
    n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]

    Output: 1
*/

class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {number}
     */

    constructor() {
        this.adjList = new Map();
    }

    buildGraph(edges) {
        edges.forEach(([src, dest]) => {
            if (!this.adjList.has(src)) this.adjList.set(src, []);
            this.adjList.get(src).push(dest);

            if (!this.adjList.has(dest)) this.adjList.set(dest, []);
            this.adjList.get(dest).push(src);
        })
    }

    countComponents(n, edges) {
        this.buildGraph(edges);

        let c = n - this.adjList.size;
        const visited = new Set();

        const dfs = (curr) => {
            visited.add(curr);

            const depdList = this.adjList.get(curr);
            depdList.forEach(node => {
                if (!visited.has(node)) {
                    dfs(node);
                }
            })
        }

        this.adjList.keys().forEach(node => {
            if (!visited.has(node)) {
                c++;
                dfs(node);
            }
        });

        return c;
    }


}
