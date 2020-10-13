package sort;

import java.util.Arrays;

/**
 * @Author: huijz
 * @email: 670478647@qq.com
 * @Date: 2020/10/13 15:34
 * @Desc: 快速排序
 *
 * <p>
 * 基本思想：（分治）
 * 先从数列中取出一个数作为key值；
 * 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
 * 对左右两个小数列重复第二步，直至各区间只有1个数。
 * 快速排序由于排序效率在同为O(N*logN)的几种排序方法中效率较高，因此经常被采用，再加上快速排序思想----分治法也确实实用，因此很多软件公司的笔试面试，包括像腾讯，微软等知名IT公司都喜欢考这个，还有大大小的程序方面的考试如软考，考研中也常常出现快速排序的身影。
 * 总的说来，要直接默写出快速排序还是有一定难度的，因为本人就自己的理解对快速排序作了下白话解释，希望对大家理解有帮助，达到快速排序，快速搞定。
 * 快速排序是C.R.A.Hoare于1962年提出的一种划分交换排序。它采用了一种分治的策略，通常称其为分治法(Divide-and-ConquerMethod)。
 * <p>
 * 该方法的基本思想是：
 * 1．先从数列中取出一个数作为基准数。
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 * 虽然快速排序称为分治法，但分治法这三个字显然无法很好的概括快速排序的全部步骤。因此我的对快速排序作了进一步的说明：挖坑填数+分治法：
 *
 * <p>
 * 平均时间复杂度：O(N*logN)
 */
public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {11, 22, 13, 16, 17, 18, 45, 89, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        //选择第一个数为key
        int key = arr[l];

        while (i < j) {
            //从右向左找第一个小于key的值
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //从左向右找第一个大于key的值
            while (i < j && arr[i] < key) {
                i++;
            }

            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //i == j
        arr[i] = key;
        //递归调用
        quickSort(arr, i + 1, r);
        //递归调用
        quickSort(arr, l, i - 1);

    }

}
