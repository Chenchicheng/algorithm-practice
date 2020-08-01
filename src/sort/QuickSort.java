package sort;

/**
 * @author chicheng
 * @date 2020/8/1 16:47
 * @description 快速排序
 */
public class QuickSort {

    public static void quickSort1(int a[], int left, int right) {
        if (left < right) {
            int m = partition1(a, left, right);
            quickSort1(a, left, m - 1);
            quickSort1(a, m + 1, right);
        }
    }

    private static int partition1(int[] a, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int index = left;
        // 小于区域左边界
        int less = left - 1;
        while(index < right) {
            if (a[index] <= a[right]) {
                // 将小于区域的右一个值与当前值交换，小于区域右扩，index++
                swap(a, index, less + 1);
                less++;
            }
            index++;
        }
        swap(a, less + 1, right);
        return less + 1;

    }

    public static void quickSort2(int a[], int left, int right) {
        if (left < right) {
            int[] m = partition2(a, left, right);
            quickSort2(a, left, m[0] - 1);
            quickSort2(a, m[1] + 1, right);
        }
    }

    private static int[] partition2(int[] a, int left, int right) {
        if (left > right) {
            return new int[]{-1,-1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        int index = left;
        // 小于区域左边界
        int less = left - 1;
        // 大于区域右边界
        int more = right;
        while (index < more) {
            if (a[index] == a[right]) {
                index++;
            } else if (a[index] <= a[right]) {
                // 将小于区域的右一个值与当前值交换，小于区域右扩，index++
                swap(a, index, less + 1);
                less++;
                index++;
            } else {
                // 将大于区域的左一个值与当前值交换，大于区域左扩，index不变
                swap(a, index, more - 1);
                more--;
            }
        }
        swap(a, more, right);
        return new int[] {less + 1, more};
    }

    private static void swap(int []arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
