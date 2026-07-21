/*
    https://www.greatfrontend.com/interviews/study/blind75/questions/algo/graph-is-tree
*/

/**
 * @param {number} num
 * @param {Array<[number, number]>} edges
 * @return {boolean}
 */
export default function graphIsTree(num, edges) {
    if (edges.length !== num - 1) return false;

    const adjList = new Map();
    edges.forEach(([start, end]) => {
        if (!adjList.has(start)) adjList.set(start, []);
        adjList.get(start).push(end);

        if (!adjList.has(end)) adjList.set(end, []);
        adjList.get(end).push(start);
    });

    const visited = new Set();
    function checkCycle(node, parent) {
        visited.add(node);

        const children = adjList.get(node) || [];
        for (let i = 0; i < children.length; i++) {
            const curr = children[i];

            if (parent === curr) continue;

            if (visited.has(curr)) return true; // if the visited node is encountered again -> has cycle
            if (checkCycle(curr, node)) return true;
        }

        return false;
    }

    // for a graph to be tree: must be acyclic & all nodes should be visited in a single go
    if (checkCycle(0, null)) return false;

    return visited.size === num;
}
