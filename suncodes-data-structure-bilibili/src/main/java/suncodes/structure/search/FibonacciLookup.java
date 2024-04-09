package suncodes.structure.search;

import suncodes.structure.sort.QuickSort;

import java.util.Arrays;

/**
 * 斐波那契查找
 * 也是二分查找的一种提升算法， 通过运用黄金比例的概念在数列中选择查找点进行查找， 提高查找效率。同样地，斐波那契查找也属于一种有序查找算法。
 */
public class FibonacciLookup {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 6, 7, 8, 6};
        // 先排序
        QuickSort.quickSort(a, 0, a.length - 1);
        int value = fiboSearch(a, 1);
        System.out.println(value);
    }

    //得到一个斐波那契数组
    public static int[] fibonacci(int n) {
        //初始化数组
        int[] fibo = new int[n];

        if (n >= 1) fibo[0] = 1;
        if (n >= 2) fibo[1] = 1;

        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo;
    }
    //主方法

    /**
     * @param arr     待查找序列
     * @param findVal 查找的目标值
     * @return 返回目标值所在的下标
     */
    public static int fiboSearch(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int maxsize = 20;

        //得到斐波那契数组
        int[] fibo = fibonacci(maxsize);

        //判断待查找序列长度应该为哪一个斐波那契数
        while (high > fibo[k] - 1) {
            k++;
        }
        //填充待排序列, 长度为f[k]-1 把老数组复制到长度为 f[ k]的新数组中 超出老数组长度的用0填充
        int[] temp = Arrays.copyOf(arr, fibo[k] - 1);
        //填充temp数组中为0的部分
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        System.out.println("填充了最后元素的临时数组: " + Arrays.toString(temp));
        //正式开始查找
        while (low <= high) {
            mid = low + fibo[k - 1] - 1;

            //不断比较不同区间内 findVal 与 temp[mid]的关系
            if (findVal < temp[mid]) {
                high = mid - 1;
                k -= 1;
            } else if (findVal > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                //需要确定返回的是那个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
