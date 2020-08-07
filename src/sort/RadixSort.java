package sort;

/**
 * @author chicheng
 * @date 2020/8/7 21:21
 * @description 基数排序 O(N*(log10^M))
 */
public class RadixSort {
    public static void radixSort(int a[]) {
        if (a == null || a.length < 2) {
            return;
        }
        radixSort(a, 0, a.length - 1, maxbits(a));
    }

    private static int maxbits(int[] a) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0;
        int j = 0;
        // 有多少个数准备个辅助空间
        int[] help =  new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = L, j = 0; i <= R; i++, j++) {
                arr[L + i] = help[j];
            }
        }
    }

    // 获取每位数上的值 d=1,个位数; d=2,十位数
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
