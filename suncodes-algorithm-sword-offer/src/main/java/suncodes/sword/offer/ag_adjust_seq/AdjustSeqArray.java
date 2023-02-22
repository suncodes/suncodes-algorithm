package suncodes.sword.offer.ag_adjust_seq;

import java.util.Arrays;

public class AdjustSeqArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] exchange = new AdjustSeqArray().exchange(arr);
        System.out.println(Arrays.toString(exchange));
    }

    public int[] exchange(int[] nums) {

        // 定义头指针 left
        int left = 0;

        // 定义尾指针 right
        int right = nums.length - 1;

        // 定义临时变量 tmp
        int tmp;

        // 移动 left 和 right ，直到 left 在 right 右侧或者相遇为止
        while (left < right) {

            // 如果 left 指针指向的元素值是奇数，那么说明该元素在左侧了，观察其它的元素，即让 left 向右移动
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }

            // 如果 right 指针指向的元素值是偶数，那么说明该元素在右侧了，观察其它的元素，即让 right 向左移动
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }

            // 否则就说明，此时要么 left 指向的元素值为偶数，要么 right 指向的元素值为奇数
            // 交换这两个位置的元素
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        // 最后返回结果就行
        return nums;
    }
}
