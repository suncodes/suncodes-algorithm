package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1, 3, 5, 2, 4};
        mergeSortByRecursion(rawArr);
        System.out.println(Arrays.toString(rawArr));
    }

    public static void mergeSortByRecursion(int[] rawArr) {
        if (rawArr.length == 0) {
            return;
        }
        if (rawArr.length == 1) {
            return;
        }
        if (rawArr.length == 2) {
            int i = rawArr[0];
            int i1 = rawArr[1];
            if (i > i1) {
                rawArr[0] = i1;
                rawArr[1] = i;
            }
            return;
        }
        int index = rawArr.length / 2;
        int[] leftArr = Arrays.copyOfRange(rawArr, 0, index);
        int[] rightArr = Arrays.copyOfRange(rawArr, index, rawArr.length);
        mergeSortByRecursion(leftArr);
        mergeSortByRecursion(rightArr);
        int[] copyArr = new int[leftArr.length + rightArr.length];
        int i = 0;
        int j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                rawArr[i + j] = leftArr[i];
                i++;
            } else {
                rawArr[i + j] = rightArr[j];
                j++;
            }
        }
        if (i < leftArr.length) {
            for (int k = i; k < leftArr.length; k++) {
                rawArr[i + j] = leftArr[k];
            }
        }
        if (j < rightArr.length) {
            for (int k = j; k < rightArr.length; k++) {
                rawArr[i + k] = rightArr[k];
            }
        }
        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));
        System.out.println(Arrays.toString(rawArr));
        System.out.println("=============================");
    }

    public static void mergeSortByLoop(int[] rawArr) {

    }
}
