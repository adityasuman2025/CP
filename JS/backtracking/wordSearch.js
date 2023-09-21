/*
https://leetcode.com/problems/word-search/description/

79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
*/


/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    let m = board.length, n = board[0].length;

    let found = false;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let char = board[i][j];

            if (char === word[0]) {
                dfs(i, j, 1, { [i + "_" + j]: 1 });

                if (found) return true;
            }
        }
    }

    function dfs(i, j, pos, paths) {
        if ((pos > word.length) || found) return;

        if (pos === word.length) {
            found = true;
            return;
        }

        let path = (i - 1) + "_" + j;
        if (i - 1 >= 0 && board[i - 1][j] === word[pos] && !paths.hasOwnProperty(path)) {
            dfs(i - 1, j, pos + 1, { ...paths, [path]: 1 });
        }

        path = (i + 1) + "_" + j;
        if (i + 1 < m && board[i + 1][j] === word[pos] && !paths.hasOwnProperty(path)) {
            dfs(i + 1, j, pos + 1, { ...paths, [path]: 1 });
        }

        path = i + "_" + (j - 1);
        if (j - 1 >= 0 && board[i][j - 1] === word[pos] && !paths.hasOwnProperty(path)) {
            dfs(i, j - 1, pos + 1, { ...paths, [path]: 1 });
        }

        path = i + "_" + (j + 1);
        if (j + 1 < n && board[i][j + 1] === word[pos] && !paths.hasOwnProperty(path)) {
            dfs(i, j + 1, pos + 1, { ...paths, [path]: 1 });
        }

        return;
    }

    return false;
};