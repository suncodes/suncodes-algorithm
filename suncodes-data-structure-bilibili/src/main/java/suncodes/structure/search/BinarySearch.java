package suncodes.structure.search;

import suncodes.structure.sort.QuickSort;

/**
 * 二分法查找: 适用于数据量较大时，但是数据需要先排好顺序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 6, 7, 8, 6};
        // 先排序
        QuickSort.quickSort(a, 0, a.length - 1);
        int value = binarySearch(a, 0, a.length - 1, 5);
        System.out.println(value);
    }

    private static int binarySearch(int[] array, int beginIndex, int endIndex, int target) {
        if (beginIndex > endIndex) {
            return -1;
        }
        // 0,1,2,3
        int mid = (endIndex - beginIndex) / 2 + beginIndex;
        int value = array[mid];
        if (value == target) {
            return mid;
        }
        if (value < target) {
            return binarySearch(array, mid + 1, endIndex, target);
        } else {
            return binarySearch(array, beginIndex, mid - 1, target);
        }
    }
}
