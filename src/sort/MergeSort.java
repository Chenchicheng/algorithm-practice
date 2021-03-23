package sort;

/**
 * @author chicheng
 * @date 2020/8/1 17:35
 * @description 归并排序 O(N*logN), 稳定
 */
public class MergeSort {

    /**
     * 归并排序， 递归方式
     * @param a
     * @param left  数组的最左下标
     * @param right 数组的最右下边
     */
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

    /**
     * 非递归方式实现
     * @param a
     */
    public static void mergeSort2(int a[]) {
        int n = a.length;
        int mergeSize = 1;
        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                int m = l + mergeSize - 1;
                if (m >= n) {
                    break;
                }
                int r = Math.min(l + mergeSize, n - 1);
                merge(a, l, m, r);
                l = r + 1;
            }

            /**
             * 防止数组溢出
             */
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize = mergeSize *2;
        }
    }

    public static void main(String args[]) {
        int[] a = {1,2,3,5,1,6,4,8};

        mergeSort2(a);

        for (int j : a) {
            System.out.println(j + " ");
        }
    }
}
