package sort;

/**
 * @author chicheng
 * @date 2020/8/1 17:35
 * @description 归并排序
 */
public class MergeSort {

    public static void mergeSort(int a[], int left, int right) {
        if (a == null || a.length < 2) {
            return;
        }
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2 ;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
        return;

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int i = 0;
        while (l <= mid && r <= right) {
            temp[i++] = a[l] <= a[r] ? a[l++] : a[r++];
        }
        while (l <= mid) {
            temp[i++] = a[l++];
        }
        while (r <= right) {
            temp[i++] = a[r++];
        }
        for (i = 0; i < temp.length; i++) {
            a[left + i] = temp[i];
        }
    }
}
