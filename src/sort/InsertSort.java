package sort;

/**
 * @author chicheng
 * @date 2020/8/7 20:38
 * @description 插入排序 O(N^2), 稳定
 */
public class InsertSort {

    public static void insertSort(int a[]) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];

            // 寻找要插入的位置
            int k = i - 1;
            for (; k >= 0; --k) {
                if (a[k] > value) {
                    a[k+1] = a[k];
                } else {
                    break;
                }
            }
            a[k+1] = value;
        }
    }
}
