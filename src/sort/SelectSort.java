package sort;

/**
 * @author chicheng
 * @date 2020/8/7 20:51
 * @description 选择排序 O(N^2), 不稳定
 */
public class SelectSort {

    public static void selectSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(a, minIndex, i);
            }
        }
    }

    private static void swap(int []arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
