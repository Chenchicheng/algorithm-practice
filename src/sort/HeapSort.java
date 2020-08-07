package sort;

/**
 * @author chicheng
 * @date 2020/8/5 21:55
 * @description 堆排序 O(N*logN), 不稳定
 * 排序原理：
 *      1、先让整个数组变成大根堆结构
 *          1、由上至下建立大根堆(O(N*logN))
 *          2、由下至上建立大根堆(O(N))
 *      2、把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，一直周而复始(O(N*logN))
 *      3、堆的大小减为0之后，排序完成
 */
public class HeapSort {

    public static  void heapSort(int a[]) {
        if (a == null || a.length < 2) {
            return;
        }
        // 由上至下建立大根堆
        /*for (int i = 0; i < a.length; i++) {
            heapInsert(a, i);
        }*/
        int heapSize = a.length;
        // 由下至上建立大根堆
        for (int i = a.length - 1; i >= 0; i--) {
            heapIfy(a, i,  heapSize);
        }
        swap(a, 0, --heapSize);

        while (heapSize > 0) {
            heapIfy(a, 0, heapSize);
            swap(a, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] a, int index) {
        while (a[index] > a[(index - 1) /2]) {
            swap(a, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapIfy(int[] a, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            // 取左右孩子中较大的那个值的下标与a[index]替换
            int largest = (left + 1) < heapSize && a[left + 1] > a[left] ? left + 1 : left;
            largest = a[largest] > a[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(a, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void swap(int []arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
