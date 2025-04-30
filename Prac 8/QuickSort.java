public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    @SuppressWarnings("unchecked")
    public Comparable<T>[] sort(Comparable<T>[] arr) {
        printArr(arr);
        // Add code below this line

        if (arr.length <= 1) {
            return arr;
        }

        int pivotIndex = getPivotPoint(arr);
        Comparable<T> pivot = arr[pivotIndex];

        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex].compareTo((T) pivot) < 0) {
                leftIndex++;
            }

            while (arr[rightIndex].compareTo((T) pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        if (arr.length == 0) {
            return arr;
        }
        printArr(arr);

        sort(arr, 0, rightIndex);
        sort(arr, leftIndex, arr.length - 1);
        printArr(arr);

        return arr;
    }

    private void sort(Comparable<T>[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            sort(arr, low, partitionIndex - 1);
            sort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(Comparable<T>[] arr, int low, int high) {
        printArr(arr);
        Comparable<T> pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo((T) pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        printArr(arr);
        return i + 1;
    }

    private void swap(Comparable<T>[] data, int leftIndex, int rightIndex) {
        // printArr(data);
        Comparable<T> temp = data[leftIndex];
        data[leftIndex] = data[rightIndex];
        data[rightIndex] = temp;
    }

    // @SuppressWarnings("unchecked")
    // private Comparable<T>[] recSort(Comparable<T>[] arr, Comparable<T>[]
    // resultingArr) {
    // printArr(arr);
    // // Add code below this line

    // }

    private int getPivotPoint(Comparable<T>[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        if (arr.length % 2 == 0)
            return (int) Math.floor(arr.length / 2) - 1;
        else
            return (int) Math.floor(arr.length / 2);
    }
}
