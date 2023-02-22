package suncodes.sword.offer.af_way_array;

public class Way4Array {
    public static void main(String[] args) {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        System.out.println(new Way4Array().exist(board1, word1));
        // board = [["a","b"],["c","d"]], word = "abcd"
        char[][] board2 = {{'a', 'b'}, {'c', 'd'}};
        String word2 = "abcd";
        System.out.println(new Way4Array().exist(board2, word2));
    }

    public boolean exist(char[][] board, String word) {
        // 先将字符串进行拆分，一个一个元素进行匹配
        char[] words = word.toCharArray();
        // 通过两层嵌套，覆盖所有的情况
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 以该元素为起始点，递归检查是否符合要求
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 边界情况判断
        // 行越界
        // 列越界
        // 矩阵元素已访问过
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }

        // 之前已经和目标字符串匹配成功了 length - 1 个字符，此时又匹配成功了最后一个元素，直接返回结果
        if (k == word.length - 1) {
            return true;
        }

        // 标记当前矩阵元素，将其修改为特殊字符 #  ，代表此元素已访问过，防止之后搜索时重复访问。
        board[i][j] = '#';


        //  检查元素的四个方向 上 左 下 右

        boolean res = dfs(board, word, i, j - 1, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i + 1, j, k + 1);


        board[i][j] = word[k];
        return res;
    }
}
