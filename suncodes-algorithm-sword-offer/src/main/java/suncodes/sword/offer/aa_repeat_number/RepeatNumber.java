package suncodes.sword.offer.aa_repeat_number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 核心思路：利用哈希冲突的原理
 */
public class RepeatNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 1, 0, 2, 5, 3);
        Set<Integer> sets = new HashSet<Integer>();
        for (Integer integer : list) {
            boolean add = sets.add(integer);
            if (!add) {
                System.out.println(integer);
            }
        }
    }
}
