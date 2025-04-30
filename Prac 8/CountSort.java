public class CountSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    @SuppressWarnings("unchecked")
    public Comparable<T>[] sort(Comparable<T>[] arr) {
        int[] count = formCountArr(arr);
        printArr(arr, count);
        int[] sumCount = sumCount(count);
        printArr(arr, sumCount);
        Comparable<T>[] res = new Comparable[arr.length];
        int[] tmp = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            tmp[count[arr[i].hashCode()] - 1] = arr[i].hashCode();
            count[arr[i].hashCode()]--;
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = (T) ((Object) tmp[i]); // Cast the sorted values appropriately
        }

        printArr(res, sumCount);

        return res;
    }

    private int[] formCountArr(Comparable<T>[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i].hashCode());
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                count[0]++;
            } else {
                count[arr[i].hashCode()]++;
            }
        }

        return count;
    }

    private int[] sumCount(int[] countArr) {
        int[] result = new int[countArr.length];
        result[0] = countArr[0];
        for (int i = 1; i < countArr.length; i++) {
            result[i] = result[i - 1] + countArr[i];
        }

        return result;

    }

    private int countArraySize(Comparable<T>[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i].hashCode());
        }

        return max + 1;

    }

    private void printArr(Comparable<T>[] arr, int[] count) {
        if (arr == null || count == null)
            System.out.println("NULL ARRAYS");

        String res = "[";
        for (Comparable<T> t : arr) {
            res += t + "{" + count[t.hashCode()] + "},";
        }
        if (res.length() > 0) {
            res = res.substring(0, res.length() - 1);
        }
        res += "]";
        System.out.println(res);
    }

}
