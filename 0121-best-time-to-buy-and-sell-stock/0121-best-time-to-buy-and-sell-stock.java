class Solution {
    public int maxProfit(int[] prices) {
        int buyingprice = Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0;i < prices.length;i++){
           if(buyingprice<prices[i]){
            int profit = prices[i] - buyingprice;
            maxProfit = Math.max(maxProfit,profit); 
           }else{
             buyingprice=prices[i];
            
           }
        
        }
        return maxProfit;
    }
}