package sort;

import java.util.Arrays;

/**
 * @Author: huijz
 * @email: 670478647@qq.com
 * @Date: 2020/10/13 14:50
 * @Desc: 选择排序
 * <p>
 * 基本思想：
 * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
 * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
 * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
 * <p>
 * 平均时间复杂度：O(n2)
 */
public class SelctionSort {

    public static void main(String[] args) {
        int[] arr = {12, 47, 67, 32, 65, 23, 34, 54};
        selctionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selctionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
            }
        }

    }
}
