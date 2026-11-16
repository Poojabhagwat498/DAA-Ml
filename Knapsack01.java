
import java.util.Scanner;

public class Knapsack01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        // Input weights
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        // Input profits
        System.out.println("Enter profits of items:");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        // Input knapsack capacity
        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        // Create DP table
        int[][] dp = new int[n + 1][capacity + 1];

        // Dynamic Programming
        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                if (weight[i - 1] <= w) {

                    // Include or exclude the item
                    dp[i][w] = Math.max(
                            profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                            dp[i - 1][w]);

                } else {

                    // Exclude the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Display maximum profit
        System.out.println("Maximum Profit = " + dp[n][capacity]);

        sc.close();
    }
}
