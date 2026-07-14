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
    countComponents(n, edges) {
        const adjList = new Map();

        // building graph
        edges.forEach(([src, dest]) => {
            if (!adjList.has(src)) adjList.set(src, []);
            adjList.get(src).push(dest);

            if (!adjList.has(dest)) adjList.set(dest, []);
            adjList.get(dest).push(src);
        })

        let c = n - adjList.size; // some nodes might not have any edge i.e. they are compltely isolated -> n - adjList.size (nodes having edge) will result into those isolated nodes
        const visited = new Set();

        const dfs = (curr) => {
            visited.add(curr);

            const depdList = adjList.get(curr);
            depdList.forEach(node => {
                if (!visited.has(node)) {
                    dfs(node);
                }
            })
        }

        adjList.keys().forEach(node => {
            if (!visited.has(node)) {
                c++;
                dfs(node);
            }
        });

        return c;
    }
}
