package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 2, 1, 4, 6 };
        sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sort(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        int i = 0;
        int j = 0;

        for(; i < len; i++){
            if(i < mid){
                left[i] = nums[i];
            }else{
                right[j] = nums[i];
                j++;
            }
        }
        sort(left);
        sort(right);
        merge(left, right, nums);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int lenL = arr.length / 2;
        int lenR = arr.length - lenL;
        int i = 0, l = 0, r = 0;
        while(l < lenL && r < lenR){
            if(left[l] < right[r]){
                arr[i] = left[l];
                i++;
                l++;
            }else{
                arr[i] = right[r];
                i++;
                r++;
            }
        }
        while(l < lenL){
            arr[i] = left[l];
            i++;
            l++;
        }
        while(r < lenR){
            arr[i] = right[r];
            i++;
            r++;
        }
    }
}
