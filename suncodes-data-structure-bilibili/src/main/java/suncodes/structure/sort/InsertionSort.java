package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1,3,5,2,4};
        insertionSort(rawArr);
//        System.out.println(Arrays.toString(rawArr));
    }

    /**
     * 插入排序，从小到大
     * @param rawArr
     */
    public static void insertionSort(int[] rawArr) {
        int[] insertArr = new int[rawArr.length];
        for (int j = 0; j < rawArr.length; j++) {
            int value = rawArr[j];
            sort(insertArr, value, j);
        }
        System.out.println(Arrays.toString(insertArr));
    }

    private static void sort(int[] insertArr, int value, int i) {
        int index = i;
        for (int j = 0; j < i; j++) {
            int v = insertArr[j];
            if (v > value) {
                index = j;
                break;
            }
        }
        for (int j = i - 1; j >= index; j--) {
            int v = insertArr[j];
            insertArr[j + 1] = v;
        }
        insertArr[index] = value;
    }
}
