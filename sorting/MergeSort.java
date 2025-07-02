public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 10, -7, 8, 9, 1, 5 };

        mergeSort(arr);
        System.out.println("Sorted array: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int i = 0; i < mid; i++) { // left ko bharo with elements till mid
            left[i] = arr[i];
        }
        for (int i = mid; i < len; i++) { // right ko bharo with elements mid and aage
            right[i - mid] = arr[i];
        }
        mergeSort(left); // 
        mergeSort(right);
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int lenL = left.length;
        int lenR = right.length;
        int l = 0, r = 0, main = 0;
        while (l < lenL && r < lenR) {
            if (left[l] < right[r]) {
                arr[main++] = left[l++];
            }else {
                arr[main++] = right[r++];
            }
        }
        while (l < lenL) {
            arr[main++] = left[l++];
        }
        while (r < lenR) {
            arr[main++] = right[r++];
        }
    }
}