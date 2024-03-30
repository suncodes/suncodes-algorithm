package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1, 3, 5, 2, 4, 16, 6, 7, 8, 9, 17, 10, 11, 12, 13, 14, 15};
        new CountingSort().countingSort(rawArr);
        System.out.println(Arrays.toString(rawArr));

        int[] rawArr1 = new int[]{1, 3, 5, 2, 4, 16, 6, 7, 8, 9, 17, 10, 11, 12, 13, 14, 15};
        new CountingSort().countingSort1(rawArr1);
        System.out.println(Arrays.toString(rawArr1));
    }

    /**
     * 第一种方式（取巧）
     * @param rawArr
     */
    public void countingSort(int[] rawArr) {
        int max = 0;
        for (int i : rawArr) {
            max = Math.max(i, max);
        }
        int[] countArr = new int[max + 1];
        for (int i : rawArr) {
            int count = countArr[i];
            count++;
            countArr[i] = count;
        }
        // 前缀和（省略）
        int num = 0;
        for (int j = 0; j < countArr.length; j++) {
            int i = countArr[j];
            for (int k = 0; k < i; k++) {
                rawArr[num] = j;
                num++;
            }
        }
    }

    public void countingSort1(int[] rawArr) {
        int max = 0;
        for (int i : rawArr) {
            max = Math.max(i, max);
        }
        int[] countArr = new int[max + 1];
        for (int i : rawArr) {
            int count = countArr[i];
            count++;
            countArr[i] = count;
        }
        // 前缀和
        int num = 0;
        for (int j = 0; j < countArr.length; j++) {
            int count = countArr[j];
            countArr[j] = num + count;
            num += count;
        }
        // 最终排序结果
        int[] results = new int[rawArr.length];
        // 倒序遍历时稳定算法（正序遍历时非稳定算法）
        for (int i = rawArr.length - 1; i >= 0; i--) {
            int value = rawArr[i];
            int count = countArr[value];
            results[count - 1] = value;
            countArr[value] = count - 1;
        }
        // 数组复制
        System.arraycopy(results, 0, rawArr, 0, results.length);
    }
}
