import java.util.Stack;

class NextGreaterPreviousSmallerElement {

    public static void main(String[] args) {
        int[] nums = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
        System.out.println("Array: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        int[] nge = nge(nums);
        System.out.println("\nNGE: ");
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }
        int[] pse = pse(nums);
        System.out.println("\nPSE: ");
        for (int i = 0; i < pse.length; i++) {
            System.out.print(pse[i] + " ");
        }
    }

    public static int[] pse(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        pse[0] = -1;
        st.push(nums[0]);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();
            st.push(nums[i]);
        }
        return pse;
    }

    public static int[] nge(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        nge[n - 1] = -1;
        st.push(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (!st.isEmpty())
                nge[i] = st.peek();
            else
                nge[i] = -1;
            st.push(nums[i]);
        }
        return nge;
    }
}