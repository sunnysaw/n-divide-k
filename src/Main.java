/*
Question : Given Array of size n and a number k, find all elements that appear more than n/k times
__________________________________________________________________________________________________________
Input: arr[] = {3, 1, 2, 2, 1, 2, 3, 3}, k = 4
Output: {2, 3}
Explanation: Here n/k is 8/4 = 2, therefore 2 appears 3 times in the array that is greater than 2 and 3 appears 3
            times in the array that is greater than 2
____________________________________________________________________________________________________________________
Input: arr[] = {9, 8, 7, 9, 2, 9, 7}, k = 3
Output: {9}
Explanation: Here n/k is 7/3 = 2, therefore 9 appears 3 times in the array that is greater than 2.
 */

import java.util.Scanner;

public class Main {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        // Initialize arrays to store maximum profit for the first and second buy/sell
        int[] firstBuy = new int[n];
        int[] firstSell = new int[n];
        int[] secondBuy = new int[n];
        int[] secondSell = new int[n];

        // Initialize the first buy and sell
        firstBuy[0] = -prices[0];
        firstSell[0] = 0;

        // Initialize the second buy and sell
        secondBuy[0] = -prices[0];
        secondSell[0] = 0;

        for (int i = 1; i < n; i++) {
            // Update the first buy and sell
            firstBuy[i] = Math.max(firstBuy[i - 1], -prices[i]);
            firstSell[i] = Math.max(firstSell[i - 1], firstBuy[i - 1] + prices[i]);

            // Update the second buy and sell
            secondBuy[i] = Math.max(secondBuy[i - 1], firstSell[i - 1] - prices[i]);
            secondSell[i] = Math.max(secondSell[i - 1], secondBuy[i - 1] + prices[i]);
        }

        // The maximum profit is obtained by selling at the second sell point
        return secondSell[n - 1];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of array :");
        int length = input.nextInt();
        System.out.println("Enter the element inside array :");
        int[] array = new int[length];
        for (int start = 0; start < array.length; start++){
            array[start] = input.nextInt();
        }
        System.out.println("Printing the result :");
        System.out.println(maxProfit(array));
    }
}