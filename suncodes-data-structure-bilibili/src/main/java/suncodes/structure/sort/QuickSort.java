package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 快速排序的基本思想是：选择一个基准元素，将数组划分为两个子数组，比基准元素小的元素放在左边，比基准元素大的元素放在右边，
 * 然后分别对左右子数组进行排序，最终实现整个数组的有序排列。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1, 3, 5, 2, 4};
        quickSort(rawArr, 0, rawArr.length - 1);
        System.out.println(Arrays.toString(rawArr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int i = left, j = right;
        // 选择数组的第一个元素作为基准
        int pivot = arr[left];

        while (i < j) {
            // 从右往左找到第一个小于pivot的数
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // 从左往右找到第一个大于pivot的数
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            // 交换这两个数
            if (i < j) swap(arr, i, j);
        }

        // 把基准放到它正确的位置上，此时i=j
        swap(arr, left, i);

        // 递归处理左半部分
        quickSort(arr, left, i - 1);
        // 递归处理右半部分
        quickSort(arr, i + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
