package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1,3,5,2,4};
        bubbleSort(rawArr);
        System.out.println(Arrays.toString(rawArr));
    }

    /**
     * 冒泡排序，从小到大
     * @param rawArr
     */
    public static void bubbleSort(int[] rawArr) {
        for (int i = 0; i < rawArr.length - 1; i++) {
            for (int j = i; j < rawArr.length - 1; j++) {
                int value1 = rawArr[j];
                int value2 = rawArr[j + 1];
                if (value2 < value1) {
                    rawArr[j] = value2;
                    rawArr[j + 1] = value1;
                }
            }
        }
    }
}
