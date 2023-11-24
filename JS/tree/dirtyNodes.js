/*
    given a tree of multiple nodes, and node can be dirty.
    and a parent node also becomes dirty if all its children nodes are dirty,

    return a array of all the dirty nodes.
*/


const input = {
    id: 1,
    children: [
        {
            id: 2,
            children: [
                {
                    id: 13,
                    children: []
                }
            ]
        },
        {
            id: 3,
            children: [
                {
                    id: 4,
                    children: [
                        {
                            id: 8,
                            children: [],
                            isDirty: true
                        }
                    ]
                },
                {
                    id: 5,
                    children: [
                        {
                            id: 9,
                            children: [],
                            isDirty: true
                        },
                        {
                            id: 10,
                            children: [],
                            isDirty: true
                        }
                    ]
                },
                {
                    id: 6,
                    children: [
                        {
                            id: 11,
                            children: [],
                            isDirty: true
                        },
                        {
                            id: 12,
                            children: [],
                            isDirty: true
                        }
                    ]
                }
            ]
        },
        {
            id: 7,
            children: []
        }
    ]
}

// ans: [8, 4, 9, 10, 5, 11, 12, 6, 3]


function removeDirtyNodes(root) {
    if (!root) return false;

    let out = [];

    dfs(root);
    function dfs(root) {
        if (root.isDirty) out.push(root.id);

        const children = root.children;
        const len = children.length;

        let i = 0;
        let dirtyCount = 0;
        while (i < len) {
            const thisChildren = children[i];

            if (dfs(thisChildren)) {
                out.push(thisChildren.id);
                root.children[i].isDirty = true;
            }

            if (thisChildren.isDirty) dirtyCount++;
            i++
        }

        if (len && dirtyCount === len) return true;

        return false;
    }

    return out;
}

console.log(removeDirtyNodes(input))