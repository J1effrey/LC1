<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Dynamic Programming</details><br>

<div>👍 30349, 👎 1111<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=best-time-to-buy-and-sell-stock" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.online/algo/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程：

```python
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max( 今天选择 rest,        今天选择 sell       )

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
              max( 今天选择 rest,         今天选择 buy         )
```

通用 base case：

```python
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

特化到 `k = 1` 的情况，状态转移方程和 base case 如下：

```python
状态转移方程：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], -prices[i])

base case：
dp[i][0] = 0;
dp[i][1] = -prices[i];
```

详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.online/algo/fname.html?fname=团灭股票问题)**

**标签：[二维动态规划](https://labuladong.online/algo/)，[动态规划](https://labuladong.online/algo/)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2));
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n)]
        for i in range(n):
            if i - 1 == -1:
                # base case
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        return dp[n - 1][0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxProfit(prices []int) int {
    n := len(prices)
    dp := make([][]int, n)
    for i := 0; i < n; i++ {
        dp[i] = make([]int, 2)
        if i - 1 == -1 {
            // base case
            dp[i][0] = 0
            dp[i][1] = -prices[i]
            continue
        }
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
        dp[i][1] = max(dp[i-1][1], -prices[i])
    }
    return dp[n-1][0]
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    const n = prices.length;
    const dp = new Array(n).map(() => new Array(2));
    for (let i = 0; i < n; i++) {
        if (i - 1 === -1) {
            // base case
            dp[i][0] = 0;
            dp[i][1] = -prices[i];
            continue;
        }
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_best-time-to-buy-and-sell-stock" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_best-time-to-buy-and-sell-stock"></div></div>
</details><hr /><br />

**类似题目**：
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>

