package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1,3,5,2,4};
        selectionSort(rawArr);
        System.out.println(Arrays.toString(rawArr));
    }

    /**
     * 选择排序，从小到大
     * @param rawArr
     */
    public static void selectionSort(int[] rawArr) {
        for (int i = 0; i < rawArr.length - 1; i++) {
            int value1 = rawArr[i];
            // 找到其他最小值
            int t = i;
            for (int j = i + 1; j < rawArr.length; j++) {
                int value2 = rawArr[j];
                if (value2 < rawArr[t]) {
                    t = j;
                }
            }
            if (t > i) {
                rawArr[i] = rawArr[t];
                rawArr[t] = value1;
            }
        }
    }
}
