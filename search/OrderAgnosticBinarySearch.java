package search;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        SampleArrAndSort samp = new SampleArrAndSort();
        int[] arrAsc = samp.arr;
        int[] arrDesc = { 81, 43, 33, 24, 16, 12, 3 };
        int ind;
        int t = 33;
        samp.quickSort(arrAsc, 0, samp.lastInd);
        if (arrAsc[0] < arrAsc[samp.lastInd]) {
            ind = ascBinarySearch(arrAsc, t, 0, samp.lastInd);
            System.out.printf("For ascending sorted array, found %d at %d\n", t, ind);
        }
        ind = descBinarySearch(arrDesc, t, 0, 5);
        System.out.printf("For descending order sorted array, found %d at %d\n", t, ind);
    }

    public static int ascBinarySearch(int[] arr, int t, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (t == arr[mid]) {
            return mid;
        } else if (t > arr[mid]) {
            return ascBinarySearch(arr, t, mid + 1, end);
        } else {
            return ascBinarySearch(arr, t, start, mid - 1);
        }

    }

    public static int descBinarySearch(int[] arr, int t, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (t == arr[mid]) {
            return mid;
        } else if (t < arr[mid]) {
            return descBinarySearch(arr, t, mid + 1, end);
        } else {
            return descBinarySearch(arr, t, start, mid - 1);
        }

    }
}
