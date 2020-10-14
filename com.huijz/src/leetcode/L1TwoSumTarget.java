package leetcode;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @Author: huijz
 * @email: 670478647@qq.com
 * @Date: 2020/10/14 9:56
 * @Desc: 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * </p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L1TwoSumTarget {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 7, 8, 0, 9};
        L1TwoSumTarget1(arr, 9);
        L1TwoSumTarget2(arr, 9);

    }

    /**
     * 解法一：
     * 穷举遍历，双循环。一个从头开始，一个从尾开始。尾部与头部相遇时结束。
     */
    public static int[] L1TwoSumTarget1(int[] arr, int target) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (arr[i] + arr[j] == target) {
                    System.out.print(Arrays.toString(new int[]{i, j}));
                }
            }
        }
        return new int[0];
    }

    /**
     * 解法二：利用hash表将数组遍历存储，遍历时判断has表中有没有需要的值，如果有则取出，如果没有则将本次数据存入hash表以供检索
     */
    public static int[] L1TwoSumTarget2(int[] arr, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int remainder = target - arr[i];
            if (hashtable.containsKey(remainder)) {
                System.out.print(Arrays.toString(new int[]{hashtable.get(remainder), i}));
                //return new int[]{hashtable.get(remainder), i};
            }
            hashtable.put(arr[i], i);

        }
        return new int[0];
    }
}
