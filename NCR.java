import java.util.Scanner;

public class NCR {
    public static void main(String[] args) {
        System.out.println("Enter n and r: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println("Answer is: " + ncr(n, r));
        sc.close();
    }

    public static int ncr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}
