/*
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Ex:
Input: [7,1,5,3,6,4]
Output: 7
Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

-1 -> 4 -> 1 -> 7 ->

Ex.
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
-1 -> 

idea - loop through list checking 1 day ahead and determine which immediate transaction will net us more profit?
- if the next pair of buy sells nets us more profit do it otherwise do nothing


*/

public class stock2{
        public static int buyStocks(int [] stocks){
            int profit = 0;
            for(int i = 0; i < stocks.length - 1; i++){
                profit = Math.max(profit, profit + stocks[i + 1] - stocks[i]);
                System.out.println(profit);
            }
            return profit;
        }
    public static void main (String [] args){
        int [] temp = new int []{1,2,3,4,5};
        buyStocks(temp);
    }
}