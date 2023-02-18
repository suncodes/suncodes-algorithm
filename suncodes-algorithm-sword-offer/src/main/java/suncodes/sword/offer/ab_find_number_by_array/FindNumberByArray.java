package suncodes.sword.offer.ab_find_number_by_array;

public class FindNumberByArray {
    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(array, 5));
        System.out.println(findNumberIn2DArray(array, 20));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        // 从数组的最左下角位置开始去搜索整个二维数组
        // 1、当发现当前遍历的元素大于 target 时，意味着这个元素后面的所有元素也都大于 target
        // 那么就不用去搜索这一行了
        // 2、当发现当前遍历的元素小于 target 时，意味着这个元素上面的所有元素也都小于 target
        // 那么就不用去搜索这一列了

        // 初始化 i 和 j 为数组左下角元素
        // 最后一行
        int i = matrix.length - 1;
        // 第 0 列
        int j = 0;

        // 从数组的左下角开始出发，只要 i 和 j 没有越界继续判断
        while (i >= 0 && j < matrix[0].length) {
            // 当发现当前遍历的元素大于 target 时，意味着这个元素后面的所有元素也都大于 target
            if (matrix[i][j] > target) {
                // 行索引向上移动一格（即 i-- ），即消去矩阵第 i 行元素
                i--;
                // 当发现当前遍历的元素小于 target 时，意味着这个元素上面的所有元素也都小于 target
            } else if (matrix[i][j] < target) {
                //列索引向右移动一格（即 j++ ），即消去矩阵第 j 列元素
                j++;
                // 否则，说明找到目标值
            } else {
                // 直接返回 ture
                return true;
            }
        }
        // 遍历了整个二维数组，没有找到目标值，返回 false
        return false;
    }
}
