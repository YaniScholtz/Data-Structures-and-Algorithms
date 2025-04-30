public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    @SuppressWarnings("unchecked")
    public Comparable<T>[] sort(Comparable<T>[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        return mergeSort(arr);
    }

    private Comparable<T>[] mergeSort(Comparable<T>[] arr) {
        printArr(arr);
        if (arr.length > 1) {
            int mid = getMidPoint(0, arr.length - 1);
            Comparable<T>[] left = createSubArray(arr, 0, mid + 1);
            Comparable<T>[] right = createSubArray(arr, mid + 1, arr.length);
            Comparable<T>[] mleft = mergeSort(left);
            Comparable<T>[] mright = mergeSort(right);
            return merge(mleft, mright);
        }
        return arr;
    }

    private Comparable<T>[] merge(Comparable<T>[] lh, Comparable<T>[] rh) {
        int resultLength = lh.length + rh.length;
        Comparable<T>[] result = (Comparable<T>[]) new Comparable[resultLength];
        int i = 0, j = 0, k = 0;
        while (i < lh.length && j < rh.length) {
            if (lh[i].compareTo((T) rh[j]) <= 0) {
                result[k] = lh[i];
                i++;
            } else {
                result[k] = rh[j];
                j++;
            }
            k++;
        }
        while (i < lh.length) {
            result[k] = lh[i];
            i++;
            k++;
        }
        while (j < rh.length) {
            result[k] = rh[j];
            j++;
            k++;
        }
        return result;
    }

    private Comparable<T>[] createSubArray(Comparable<T>[] arr, int start, int end) {
        int subArrayLength = end - start;
        Comparable<T>[] subArray = (Comparable<T>[]) new Comparable[subArrayLength];
        for (int i = 0; i < subArrayLength; i++) {
            subArray[i] = arr[start + i];
        }
        return subArray;
    }

    private int getMidPoint(int first, int last) {
        return (int) Math.floor((first + last) / 2);
    }
}
