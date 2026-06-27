class Solution {

    static {
        System.out.close();
    }

    public int maxProfit(int[] prices) {
        int mini = prices[0]; 
        int maxProfit = 0;

        for (int i = 1; i<prices.length; i++) {
            int cost = prices[i] - mini;

            if(cost> maxProfit) {
                maxProfit = cost;
            }

            if(mini > prices[i]) {
                mini = prices[i];
            }
        }

        return maxProfit;
    }
}