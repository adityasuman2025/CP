/*
    https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

    Dijkstra Algorithm
    Difficulty: MediumAccuracy: 50.83%Submissions: 309K+Points: 4Average Time: 25m
    Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
    You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

    Note: The Graph is connected and doesn't contain any negative weight edge.
    It is guaranteed that all the shortest distance will fit in a 32-bit integer.

    Examples:

    Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
    Output: [4, 3, 0]
    Explanation:

    Shortest Paths:
    For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
    For 2 to 1 minimum distance will be 3. By following path 2 -> 1
    For 2 to 2 minimum distance will be 0. By following path 2 -> 2
    Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
    Output: [0, 4, 8, 10, 10]
    Explanation: 

    Shortest Paths: 
    For 0 to 1 minimum distance will be 4. By following path 0 -> 1
    For 0 to 2 minimum distance will be 8. By following path 0 -> 2
    For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
    For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
*/

class MinPriorityQueue {
    constructor() {
        this.heap = [];
    }

    push(element) {
        this.heap.push(element);
        this._bubbleUp(this.heap.length - 1);
    }

    pop() {
        if (this.heap.length === 0) return null;
        const min = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = end;
            this._sinkDown(0);
        }
        return min;
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    _bubbleUp(index) {
        while (index > 0) {
            let parentIndex = Math.floor((index - 1) / 2);
            if (this.heap[index][0] >= this.heap[parentIndex][0]) break;
            [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
            index = parentIndex;
        }
    }

    _sinkDown(index) {
        const length = this.heap.length;
        while (true) {
            let leftChildIdx = 2 * index + 1;
            let rightChildIdx = 2 * index + 2;
            let smallest = index;

            if (leftChildIdx < length && this.heap[leftChildIdx][0] < this.heap[smallest][0]) {
                smallest = leftChildIdx;
            }
            if (rightChildIdx < length && this.heap[rightChildIdx][0] < this.heap[smallest][0]) {
                smallest = rightChildIdx;
            }
            if (smallest === index) break;

            [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
            index = smallest;
        }
    }
}

class Solution {
    // Returns shortest distances from src to all other vertices
    dijkstra(V, edgeList, source) {
        // building adjacency list
        const adjList = new Map();
        edgeList.forEach(([origin, dest, weight]) => {
            if (!adjList.has(origin)) adjList.set(origin, []);
            adjList.get(origin).push([dest, weight]);

            if (!adjList.has(dest)) adjList.set(dest, []);
            adjList.get(dest).push([origin, weight]);
        })

        const dist = new Array(V).fill(Infinity); // array to store the shortest distance from source to each node
        dist[source] = 0;

        const pq = new MinPriorityQueue();
        pq.push([0, source]);

        while (!priorityQueue.isEmpty()) {
            const [currentDistance, currentNode] = pq.pop();

            // if the stored distance is already less than this distance, no need to do anything
            if (dist[currentNode] < currentDistance) continue;

            adjList.get(currentNode)?.forEach(([neighborNode, edgeWeight]) => {
                if (edgeWeight + currentDistance < dist[neighborNode]) {
                    dist[neighborNode] = edgeWeight + currentDistance;
                    pq.push([edgeWeight + currentDistance, neighborNode])
                }
            })
        }

        return dist;
    }
}