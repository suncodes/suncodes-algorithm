package suncodes.structure.search;

import suncodes.structure.sort.QuickSort;

/**
 * 插值查找
 * 基于二分查找算法，将查找点的选择改进为自适应选择， 可以提高查找效率。当然，差值查找也属于有序查找。
 * mid=low+(key-a[low])/(a[high]-a[low])*(high-low)
 */
public class InterpolationLookup {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 6, 7, 8, 6};
        // 先排序
        QuickSort.quickSort(a, 0, a.length - 1);
        int value = interpolationLookup(a, 0, a.length - 1, 6);
        System.out.println(value);
    }

    private static int interpolationLookup(int[] array, int beginIndex, int endIndex, int target) {
        if (beginIndex > endIndex) {
            return -1;
        }
        // 0,1,2,3
        int mid = beginIndex + (target - array[beginIndex]) / (array[endIndex] - array[beginIndex]) * (endIndex - beginIndex);
//        int mid = (endIndex - beginIndex) / 2 + beginIndex;
        int value = array[mid];
        if (value == target) {
            return mid;
        }
        if (value < target) {
            return interpolationLookup(array, mid + 1, endIndex, target);
        } else {
            return interpolationLookup(array, beginIndex, mid - 1, target);
        }
    }
}
