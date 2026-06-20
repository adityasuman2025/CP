class Graph {
    constructor() {
        // https://www.youtube.com/watch?v=cWNEl4HE2OE

        /*
           Adjacency List
           Adjacency List represents how the nodes are connected with each other
           key represent a node and value is array of nodes with whom that node is connected
           Directed Graph -> In directed graph there is 1-way relation, like we can go from Node A to Node B, but can't go to Node A from Node B
           Undirected Graph -> In undirected graph there is 2-way relation, i.e. we can go from Node A to Node B and vice versa

           Weighted Graph -> when the edge connecting 2 nodes has some weight (some numerical value)
       */

        this.adjList = new Map(); // { node => [] } // adjacency list
    }

    // add a node/vertex
    addNode(origin) {
        this.adjList.set(origin, []);
    }

    // connection b/w two nodes
    addEdge(origin, dest, weight, isUnDirected = false) {
        // directed graph
        if (!this.adjList.has(origin)) this.addNode(origin);
        this.adjList.get(origin).push({ node: dest, weight });

        if (isUnDirected) {
            // undirected graph
            if (!this.adjList.has(dest)) this.addNode(dest);
            this.adjList.get(dest).push({ node: origin, weight });
        }
    }

    buildUndirectedGraph(data) {
        data.forEach(([origin, dest, weight]) => this.addEdge(origin, dest, weight, true));
    }

    buildDirectedGraph(data) {
        data.forEach(([origin, dest, weight]) => this.addEdge(origin, dest, weight));
    }

    print() {
        this.adjList.keys().forEach(key => console.log(key, "=>", this.adjList.get(key)));
    }

    bfs(origin, dest) {
        const q = [[origin, 0]];
        const visited = new Set();
        visited.add(origin);

        let i = 0;
        while (i < q.length) {
            const [curr, sum] = q[i];

            if (curr === dest) return { path: true, sum };

            const currDepdList = this.adjList.get(curr) || []; // get connections of the current node -> dependency list of curr

            currDepdList.forEach(({ node, weight }) => {
                if (!visited.has(node)) {
                    visited.add(node);
                    q.push([node, sum + weight]);
                }
            })

            i++; // using counter instead of q.shift(), because Array.shift take O(n) time
        }

        return { path: false, sum: 0 };;
    }

    dfs(origin, dest) {
        const visited = new Set();
        visited.add(origin);

        let isFound = false, foundSum = 0;
        function util(curr, sum) {
            if (isFound) return;

            if (curr === dest) {
                foundSum = sum;
                isFound = true;
                return;
            }

            const currDepdList = this.adjList.get(curr) || []; // get connections of the current node -> dependency list of curr

            currDepdList.forEach(({ node, weight }) => {
                if (!visited.has(node)) {
                    visited.add(node);
                    util.call(this, node, sum + weight);
                }
            })
        }
        util.call(this, origin, 0); // calling the func using .call because util is a regular function and inside a regular function this of the object who calls the func, and in case of direct calling util() global this (window) will call it

        return { path: isFound, sum: foundSum };;
    }

    topSort() {
        // https://www.youtube.com/watch?v=5lZ0iJMrUMk

        /*
            Topological Sort
            A topological sort is a graph traversal algorithm in which a dependent node v is visited only after all its dependencies are visited i.e. In topological order a node u coming before v (u, v) means v is dependent on u.
            A topological ordering is possible if and only if the graph has no directed cycles, that is, if it is a directed acyclic graph (DAG). 
            It is used in spreadsheets for dependency resolution of cells related to each other by some formula. In a spreadsheet, dependencies are parent nodes (cells referenced in formulas), and dependents are child nodes (cells containing formulas), so order will be parent then children.
            e.g. 
            A1(0, 0): 10
            B1(0, 1): =A1*2

            Topological order: A1, B1
            i.e. A1 must be processed before B1 because we can calculate value of B1 only when we know A1’s value

            type sheetGraph { [dependencyCell: number]: dependentCells[ ] }
            e.g. 
            {
            “0_0”: [“0_1”]
            }
            i.e. when 0_0 value changes then 0_1’s value must also change
        */
        const visited = new Set();
        const stack = [];

        const dfsUtil = (curr) => {
            visited.add(curr);

            const depdList = this.adjList.get(curr) || [];
            depdList.forEach(({ node }) => {
                if (!visited.has(node)) dfsUtil(node);
            })

            stack.push(curr);
        };

        this.adjList.keys().forEach(node => {
            if (!visited.has(node)) dfsUtil(node);
        })

        return stack.reverse();
    }

    detectCycleInDirected() {
        // https://www.youtube.com/watch?v=9twcmtQj4DU

        const visited = new Set();
        const visitedInCurrPath = new Set(); // recursion stack

        const dfsUtil = (curr) => {
            visited.add(curr);
            visitedInCurrPath.add(curr);

            const depdList = this.adjList.get(curr) || [];
            for (let i = 0; i < depdList.length; i++) {
                const { node } = depdList[i];

                if (visitedInCurrPath.has(node)) return true;

                if (!visited.has(node)) {
                    if (dfsUtil(node)) return true;
                }
            }

            visitedInCurrPath.delete(curr);
            return false;
        }

        const adjListKeys = [...this.adjList.keys()];
        for (let i = 0; i < adjListKeys.length; i++) {
            const node = adjListKeys[i];
            if (!visited.has(node)) {
                if (dfsUtil(node)) return true;
            }
        }

        return false;
    }

    detectCycleInUndirected() {
        const visited = new Set();

        const dfsUtil = (curr, parent) => {
            visited.add(curr);

            const depdList = this.adjList.get(curr) || [];
            for (let i = 0; i < depdList.length; i++) {
                const { node } = depdList[i];

                // skip the edge going back to the parent
                if (parent === node) continue;

                // if neighbour is already visited and it's not the parent -> we got a cycle
                if (visited.has(node)) return true;

                if (dfsUtil(node, curr)) return true;
            }

            return false;
        }

        const adjListKeys = [...this.adjList.keys()];
        for (let i = 0; i < adjListKeys.length; i++) {
            const node = adjListKeys[i];
            if (!visited.has(node)) {
                if (dfsUtil(node, null)) return true;
            }
        }

        return false;
    }
}


const flights = [
    ["PAT", "BOM", 9],  // Patna to Mumbai
    ["BOM", "CHN", 3],  // Mumbai to Chennai
    ["BOM", "AHM", 5],  // Mumbai to Ahmedabad
    ["AHM", "GOA", 3],  // Ahmedabad to Goa

    ["KOL", "DEL", 4],  // Kolkata to Delhi
    ["DEL", "BLR", 2],  // Delhi to Bengaluru
    ["BLR", "KOL", 2],  // Bengaluru to Kolkata // for creating cycle

    ["DEL", "ASR", 1],  // Delhi to Amritsar
    ["GUW", "KOL", 2],  // Guwahati to Kolkata
    ["PUN", "HYD", 1],  // Pune to Hyderabad
    ["HYD", "BLR", 6]   // Hyderabad to Bengaluru
];

// const flightGraph = new Graph();
// flightGraph.buildUndirectedGraph(flights);
// flightGraph.print();

// // is there flight (direct or not-direct) to connect Patna & Chennai
// const src = "PAT", dest = "DEL"
// const hasFlight = flightGraph.dfs(src, dest);
// console.log("is there flight (direct or not-direct) to connect", src, "&", dest, hasFlight);


// topological sort
const dag = new Graph();
dag.buildDirectedGraph(flights);
dag.print();

const topSort = dag.topSort();
console.log("topSort", topSort)

const hasCycle = dag.detectCycleInDirected()
console.log("hasCycle", hasCycle)