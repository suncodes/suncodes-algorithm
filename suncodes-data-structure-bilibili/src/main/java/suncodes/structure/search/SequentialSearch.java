package suncodes.structure.search;

/**
 * 顺序查找
 * 顺序查找适合于存储结构为顺序存储或链接存储的线性表。
 */
public class SequentialSearch {
    /**
     * @param array  数集合
     * @param target 目标数
     */
    private static int sequential(int[] array, int target) {

        int length = array.length;

        for (int i = 0; i < length ; i++) {
            if (array[i] == target){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 6, 7, 8, 6};
        int value = sequential(a, 9);
        System.out.println(value);
    }
}
