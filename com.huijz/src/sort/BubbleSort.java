package sort;

import java.util.Arrays;

/**
 * @Author: huijz
 * @email: 670478647@qq.com
 * @Date: 2020/10/13 13:56
 * @Desc: 冒泡排序
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 *
 * <p>
 * 比较相邻的两个数据，如果第二个数小，就交换位置。
 * 从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
 * 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
 * </p>
 * 平均时间复杂度：O(n2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr1 = {11, 12, 3, 13, 56, 17, 99, 18};
        int[] arr2 = {13, 12, 3, 14, 56, 17, 99, 18};
        bubbleSort1(arr1);
        bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void bubbleSort1(int[] arr) {
        //零时变量
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            /**表示趟数，一共arr.length-1次。*/
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }
        }
    }

    /**
     * 优化：
     * 针对问题：
     * 数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
     * 方案：
     * 设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
     * 这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
     */
    public static void bubbleSort2(int[] arr) {
        //是否交换的标志
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            /**表示趟数，一共arr.length-1次。*/
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j] ^ arr[j - 1];
                    arr[j - 1] = arr[j] ^ arr[j - 1];
                    arr[j] = arr[j] ^ arr[j - 1];
                    flag = true;
                }

            }
            if (!flag) {
                break;
            }
        }
    }
}
