class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length < 1) {
            return profit;
        }
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int newProfit = prices[i] - minPrice;
            if (profit < newProfit) {
                profit = newProfit;
            }
        }
        return profit;
    }
}