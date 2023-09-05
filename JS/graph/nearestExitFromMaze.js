/*
https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

1926. Nearest Exit from Entrance in Maze
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

 

Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
Example 2:


Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
Example 3:


Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
*/


/**
 * @param {character[][]} maze
 * @param {number[]} entrance
 * @return {number}
 */
var nearestExit = function (maze, entrance) {
    let m = maze.length; n = maze[0].length;
    let steps = -1;

    let q = [entrance];
    maze[entrance[0]][entrance[1]] = "+"; // blocking the entrance
    while (q.length) {
        steps++;

        let size = q.length;
        while (size) {
            let [thisI, thisJ] = q.shift();

            if (
                (thisI === 0 || thisJ === 0 || thisI === m - 1 || thisJ === n - 1) && // this is boudary cell
                ([thisI, thisJ].join(" ") !== entrance.join(" ")) // cell it not entrance
            ) {
                return steps;
            }


            if (thisI - 1 >= 0 && thisJ >= 0) {
                if (maze[thisI - 1][thisJ] === ".") {
                    maze[thisI - 1][thisJ] = "+";
                    q.push([thisI - 1, thisJ])
                }
            }

            if (thisI >= 0 && thisJ - 1 >= 0) {
                if (maze[thisI][thisJ - 1] === ".") {
                    maze[thisI][thisJ - 1] = "+";
                    q.push([thisI, thisJ - 1])
                }
            }

            if (thisI >= 0 && thisJ + 1 < n) {
                if (maze[thisI][thisJ + 1] === ".") {
                    maze[thisI][thisJ + 1] = "+";
                    q.push([thisI, thisJ + 1])
                }
            }

            if (thisI + 1 < m && thisJ >= 0) {
                if (maze[thisI + 1][thisJ] === ".") {
                    maze[thisI + 1][thisJ] = "+";
                    q.push([thisI + 1, thisJ])
                }
            }

            size--;
        }
    }

    return -1;
};