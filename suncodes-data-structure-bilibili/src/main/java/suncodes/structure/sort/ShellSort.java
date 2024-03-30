package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 希尔排序（插入排序的改进版本）
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1, 3, 5, 2, 4, 16, 6, 7, 8, 9, 17, 10, 11, 12, 13, 14, 15};
        System.out.println(rawArr.length);
        new ShellSort().shellSort(rawArr);
        System.out.println(Arrays.toString(rawArr));
    }

    public void shellSort(int[] rawArr) {
        int gap = (int) Math.floor(rawArr.length * 1.0 / 2);
        while (gap > 0) {
            System.out.println(gap);
            for (int i = 0; i < gap; i++) {
                for (int j = i; j + gap < rawArr.length; j+=gap) {
                    if (rawArr[j] > rawArr[j + gap]) {
                        int tmp = rawArr[j];
                        rawArr[j] = rawArr[j + gap];
                        rawArr[j + gap] = tmp;
                    }
                }
            }
            System.out.println(Arrays.toString(rawArr));
            gap = (int) Math.floor(gap * 1.0 / 2);
        }
    }
}
