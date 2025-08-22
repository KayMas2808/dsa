package search;

public class LinearSearch{
    public static void main(String[] args) {
        int[] arr = {3,5,4,2,6,8,34};
        int target = 4, not = 7;
        boolean inArr = linearSearch(arr, target);
        boolean notInArr = linearSearch(arr, not);
        System.out.println("Array is: ");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("\nFor 4: " + inArr + ", and for 7: " + notInArr);
    }
    public static boolean linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
}