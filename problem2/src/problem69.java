// LeetCode题目链接: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
public class problem69 {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int[] nums1 = {7,1,5,3,6,4};
        int i = solution69.maxProfit(nums1);
        System.out.println(i);

    }
}


class Solution69 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // 当前卖出能获得的利润
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            // 更新历史最低价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
