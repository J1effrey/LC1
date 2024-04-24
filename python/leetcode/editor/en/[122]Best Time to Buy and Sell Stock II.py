
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # greedy
        profit = 0
        minPrice = prices[0]
        for price in prices:
            if price > minPrice:
                profit += (price - minPrice)
                minPrice = price
            else:
                minPrice = price
        return profit
# leetcode submit region end(Prohibit modification and deletion)
