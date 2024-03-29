package suncodes.structure.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{7, 1, 3, 5, 2, 4};
        mergeSort(rawArr, 0, rawArr.length - 1);
        System.out.println(Arrays.toString(rawArr));
    }

    public static void mergeSort(int[] rawArr, int left, int right) {
        if (right <= left) {
            return;
        }
        // 取中间值
        int mid = (right + left) / 2;
        mergeSort(rawArr, left, mid);
        mergeSort(rawArr, mid + 1, right);
        // 合并
        merge(rawArr, left, mid, right);
    }

    /** 合并左子数组和右子数组 */
    static void merge(int[] nums, int left, int mid, int right) {
        // 左子数组区间为 [left, mid], 右子数组区间为 [mid+1, right]
        // 创建一个临时数组 tmp ，用于存放合并后的结果
        int[] tmp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引
        int i = left, j = mid + 1, k = 0;
        // 当左右子数组都还有元素时，进行比较并将较小的元素复制到临时数组中
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }
}
