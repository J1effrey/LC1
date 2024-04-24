
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        minVal = prices[0]
        profit = 0
        for price in prices:
            profit = max(profit, price - minVal)
            if price < minVal:
                minVal = price
        return profit
# leetcode submit region end(Prohibit modification and deletion)
