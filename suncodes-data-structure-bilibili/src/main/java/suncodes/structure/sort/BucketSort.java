package suncodes.structure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 桶排序和快速排序的区别？
 * 虽然表面上看起来两者很像，桶排序是把数据分到若干个桶里，再递归地对每一个桶进行排序；
 * 上述方法一是把（除了arr[piv]以外的）数据分到前后两个“桶”里，再递归地分别进行排序。
 * 但是桶排序在把数据分桶的时候，并不是使用数据本身两两比较的方法，而是读取数据某一位上的值再两两比较（hash）。
 * 这就使得桶排序的递归深度可以是常数，而不像上述快排方法一，递归深度和数据量 n 有关。
 * 桶排序并不属于比较排序，也就是说它用到了快速排序、归并排序等这些排序方法所无法获取的信息。（但是你可以用比较排序的方式来实现桶排序。）
 * 如果桶排序永远只使用两个桶，它与快排的效率是一样的。但是桶排序可以使用更多（但是有限）的桶，因为我们事先已经知道数据的范围，因而知道可以用多少个桶来装。
 * 比如我们知道数据取值是0-99，就可以放心建立10个桶，按照十位上的数字（0到9）将数据分到每个桶里，而不用担心出现数据100时没有对应的桶。
 * 但是快排假设我们不知道数据的范围，因此只能把数据按照“比arr[piv]大还是小”分成两个桶。
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] rawArr = new int[]{1, 3, 5, 2, 4, 16, 6, 7, 8, 9, 17, 10, 11, 12, 13, 14, 15};
        new BucketSort().bucketSort(rawArr);
        System.out.println(Arrays.toString(rawArr));
    }

    public void bucketSort(int[] rawArr) {
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i : rawArr) {
            // 映射到桶里面
            int k = ((int) Math.ceil((i * 1.0) / 2));
            bucketList.get(k).add(i);
        }
        for (List<Integer> integerList : bucketList) {
            Collections.sort(integerList);
        }
        int i = 0;
        for (List<Integer> integerList : bucketList) {
            for (Integer integer : integerList) {
                rawArr[i++] = integer;
            }
        }
    }
}
