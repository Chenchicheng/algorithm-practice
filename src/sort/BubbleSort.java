package sort;

/**
 * @author chicheng
 * @date 2020/8/7 20:44
 * @description 冒泡排序 O(N^2), 稳定
 */
public class BubbleSort {

    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    private static void swap(int []arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
