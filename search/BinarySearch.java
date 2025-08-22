package search;

public class BinarySearch {
    public static void main(String[] args) {
        SampleArrAndSort samp = new SampleArrAndSort();
        int[] arr = samp.arr;
        samp.quickSort(arr, 0, samp.lastInd);
        samp.println("Initial Array: ");
        samp.printArray(arr);
        int target = 81;
        samp.println("Item to search: " + target);
        int ind = binarySearch(arr, target, 0, samp.lastInd);
        if (ind == -1) {
            samp.println("Number " + target + " not found in array.");
        } else {
            samp.println("Found " + target + " at " + ind);
        }
    }

    public static int binarySearch(int[] arr, int t, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (t == arr[mid]) {
            return mid;
        } else if (t > arr[mid]) {
            return binarySearch(arr, t, mid + 1, end);
        } else {
            return binarySearch(arr, t, start, mid - 1);
        }
    }

}
