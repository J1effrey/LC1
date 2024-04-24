<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>On each day, you may decide to buy and/or sell the stock. You can only hold <strong>at most one</strong> share of the stock at any time. However, you can buy it then immediately sell it on the <strong>same day</strong>.</p>

<p>Find and return <em>the <strong>maximum</strong> profit you can achieve</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Dynamic Programming | Greedy</details><br>

<div>👍 13306, 👎 2679<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=best-time-to-buy-and-sell-stock-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.online/algo/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程和 base case：

```python
状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

base case：
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

特化到 `k` 无限制的情况，状态转移方程如下：

```python
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
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
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
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
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
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
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
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
        if i-1 == -1 {
            // base case
            dp[i][0] = 0
            dp[i][1] = -prices[i]
            continue
        }
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
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

var maxProfit = function(prices) {
    const n = prices.length;
    const dp = new Array(n).fill(0).map(() => new Array(2).fill(0));
    for (let i = 0; i < n; i++) {
        if (i - 1 === -1) {
            // base case
            dp[i][0] = 0;
            dp[i][1] = -prices[i];
            continue;
        }
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_best-time-to-buy-and-sell-stock-ii" data="G39zUZRu0gWNinIe8yOqNvcDOg/sBueChCgQCaEZ4YUtsu2AA+xLlhFxjHIPmU4K0VPYg0qxx84qCLeI/aa6/2n1ZYJuWZLLr2V+I+FycoNQ8nit5E833nHqHWJZv2rbPUoeUUIMbG1RLASWBZAWfhw9tbSHp2/vuzjK0BdUJPSJxIiqYlSMzN+d2Ustbd7SuvonihMV4kBxcKAd/tu0pEm/FrPA0lAH9KesRiunF6dV460vraIoiGfu33iueS+ldwNObfa1yAAGroJGxxhwYjMsMAbKwyNj2ue5O7w/rYCg0dAhd8T/aowRvbzs5m6aEHYo+Fun1tvXJN6Jdn14bzkmetWer/kJA48ydVGiIz+opPoO/fvv4lh58C1dfY53p2Z3n//3P1LVZU3tGheuPl9O4jLHwUcJSV2mHz5L/dCoF/KzLN6Ar2CH22aYe7I3Iobpp91pV8C1K1X0Rmv6QDj9pzHsDT79WrWlZpfRVvemVJ40Skz7eBznz7+P2+HgFg2xlAnN5ffJu//feXLqmIc0kJz5tvtrNhwAb6NdiXF8BONRVJ1FODzggo6EqGye1zSf6RAQPxi/XpQu1lWjYUNQRqQo2fv4P7PESMI4ivCUC9msJ/7Hp+Wi283zLabTlav7v01VETAzVhVCqe29HX/6+79wR7VUWzWqs0D1zeGvT2X0u64Gi9nw4ifp5RryGt74v+tDREpl1RLqe4+bL3e7mfSwPZrqkjmcXWfqITCIwE8JKlKeX63f2dvXrQgzWoJ1B/BrTQLCuGFqwZcptfozirafxLzfmrr8cUIy8FvixGSXvMuVuIlJnAEn5CSy1+R+eL3FjPaAO5Fx76d6hCBjwG9z7s1U38wsrbFgy2SvPdrT/gEz2gLuRIl6IwRZA36bo8ZNDHGGeEZA9tr1qaLGjLaAO1GiHoQga8Bvc9TQxCLOKDImYtl7N/n43GNGS8CdKFEfhCBrwG9z1KSJVZzhnyshstdOcfdYMaMt4E6UqC9CkDXgtzkNb+bHw0W0u4rp/vx01zrl7t21fGknjcvwoeEjv/IdcXTbxHZ+x1f7yljGEg3Qe9XD64/kKfLqe+8QzEEwjdadNc6snl9BUQxU0UTT2loyh78XJavPbx7Qtuqi4dc/4EHIJIdowr1qxMLaRvpHs/bD9t4BK6tOzJ1R8yPTxKxulqCm+tnMMePh45aPGihWPbxF7i0MxUOR1BbDJ2meCaA/TcF73Wf8aystqk5MNPbEmiBU9+RxLRzBDbFTVP2T2lsruPD96luKecX7/cdfLcbrOfxqSy1KUv0HtfGQ5KNTr+tyRyQZS8IVz37Cj8SYW2XN21hMZbO1YQ9gyV8GO1v/LVjPYyi3Uzri0HAIoQXbXI0iRVrkQWBFjlxLW4RfugI4lYZbYsSaDVopU1GNZGF8TRZaSwe46UVgUaj9/Jop5k2aP5D+XdCEoYpijsKZaZvn/tvfqSP8DAi7ZwD/cD9LSqet1acD2B7FIocWqAQtMltXauJHbqTN3I+UWJWMa0pUz6GELfERbVLA1U5zA4uoQVP9wPF2xeJ1YuA4f8+tr65WbnAEt7oyqAYfOLakZPU5hqUeBroRFS5CLFStzTzSia2jwFh+jo0/ig1BgnAMMHEEUrVT5AHmwNnIyMl09Ii08CNQgw6F0JiHoQ91AXWIj+dNSu80IQ9RA0kzCyG5wu7rB4YyFBSHGsNy1jqAAdgehSKAQ2Q2rtTEj9AIag4FNUQMmocHpAfKTgylhuzuQSf9k8kqt516yjAQX4UkIgShdjYO64OixrF4jQ1PCLyyLbk4SueBOF8BDhtHDqBVkufLyBFqwZ1DAYbcm849pQBC6fQEMoPEEchovEPBlprtg9k8TukefgTA9igzwgIUxBQh/JJZYQESq5nzNHVFzZASeENjyHvTq3cEMPUPlUqZHcq2bnLZ245mGGhX0d0iJEJxNuctDVFDrLzGlicEqHVS4eIopTtEtgLGwNnIyMl09Ii08CNQgg4aPN9mC5oCjkNCMxeFTsL1IvTr6PwF0VbpqcNmyrM8P0xB49AErvuqHdwZgO1RKMIBRGbrEgJCIziE5VBQQ+QAC0gNfR/rogXNI3G9B1PaJ4Oj3NnTDgOB+aUgCmvw7KPwOapJvL7FhmfvD3g/PpYkeqfIV4DDwnFDty+Qz0mn6BGKcDVQgCFqQltAHGJsqbjQOpDbnitivD/BhprtI1lUaVM9OJZlALZHoREOoCCGCCkiKzxAZPWyHMPWICXwVsaQ90ZJDDnchvqhUkks7o4Vr5fmjp7Qw8kAyR/DfVLjKn5Gn/GGS+tYv9Rk6eRDSw5JVUzf4Wx0NJLI0YPL7G8N3qtu+SMr4V83ZsYXeT7jPoiT33IP0C010vnLShHsv/dsV8tCbfB5ozVjSw/J7qmkcxoitzu7TfRy6vb6V6jV/zmt5z0NSuO0WfNOo+I4TVvfaVa01c9zLU+4+F+4F5jvkYc9Xs5tbzieY7TxyRR1KktaHWv/JB3pyUBGPTx4W0aPfdDDhFfBRTMXnmyMBuTvRAP2pNGADTkioHGAFofluZmXCQ7QPd06QJ+FNcBwNNDfqG3Y1AvoS5P1qjHNI41r3o/zatw8Xr3vwWAalTLeaP8JG4R+fpmIYbXYBt2x9cv4+FYHCZ5T8sq+h4LJdChiGRaDIDf7Es5efC8H/A7ZeNFqoxCkrXSTZ/IFg1fJyXsE//i31axFpIGiduJ5UaG71qIk2fyhUjRrq6CjwamMLterNR2xqjJANiqi9pQUWL0yxU20Wol2j1IFXQalahAGqWC59CpRVje1NQLyLJglqRpTicocJ2JKbvLiSrhsQVW6ZqaqQRMr1rgk1DEmXdQ12TGoRDQ9VVZCD+rcQBqFC+7x4yvwnhxfxgWyZTxer0e4l8TOtT3q4OQJpbXnGsrEfFhk/68wBN0c/sAfjVJeLOx4ti4chni26tty1nf8mZhT9BQKRPyyMxpQLVIq+2P/4RrUsx1VP2UDNw0gm8nOskCl0gjCa9Er6DVTl30pLQaDRuT0YueIoFKm5DGX025MfDg5HEM9qO1FmZCoVdfKyb03zmmObaMxhW2y831QK1C0Zit/6hQlm3ZLLicGnVbdysvL7UqlniaCrCiyVBol1kMpYgaNemtZppQiHQ/S9RpDk0sp0jFdj1KjLkXe6GgXEcQ4J1/pqK7ozeJtycezEVcnFqYF9/m0HB3T1Z1y8GP8+3ludG0wsHw+EibpuRTW5LKRTNHI1SWWPtuoJ4ApmKwv/pMnen7lUAkMSi5oST/QI04Gz65c+gc2Lg6ApjZ6/u7n6dcCq0jO/I12aoeY3IVrPOCasfPCt2H6bkixjocGitEBXVnBO8cRVPV8HmYavuPTVcL9B8utxsZz9jj1wFR78AbWS6dDV7HXMT/oPc/NVTgFmjaCjfiULkxWtrtwHnvHnonq7Ad2FHTtu0q++OVTlBrf7LkgKsGxawJUu0wN813d1rrkLfDNmhoLHbDq5S+m1hPsJM4+gMWnvPHyCz+/lvRhtHnb/1OEOpyv52cZp47xfz/PvWIZ+o3plI+FB+qOdu8WcAsj11n70nZEDzufzM6fw6AkH6C+lexk9aOq15c8a3z1AaA9CMfDXmI2vyJA77Wy3Y0vwkKBiPZzEtFp0JQjK3dvc6O9snpZEBS3W3bhoz3m7dQz5b51s9vY9uF7BfEHkhvEDiRm7MRJ5OBEyDqIxPyVCFkIEbIRImQlNPDshAgZGxFyGCIxIyFCfkGEbIEI1n8kGvkRbPkIJnsEyzwSDfAIdnYEczqC1RzBOG6ADRzB1I1g0UYwXBu4fRrBDI1gbUaiURnBdoxgIkawBBu4wRfBrotgvjVwKy2CMRbB5opE0yqCBRXBUIpgD7VwsyeCdRPBiIlgq0SiSRLB8ohgYESwI1q4uQDbxlzvUj4hsw02m/NVofbKuIUmuNIznDCrEc9qdgMWrndGnDgpYpJR4oTESRCTEMQJiRMnJpESJ0acBHFSxCQGcULiJImTQUyySZwMYpIDcULipIiTJiZ5I06cmBSMOHHipIiTJuYwKBcmJ4FKBlyCopIBl0xRCVFJoJKGSwQqcVSScMkdlSQqabgUQCWBSgoupaISQyWNHlmVHU7X7NqezwPJx51xsCRWI+/GqXpr20H9Vn/bzQ41PKy0UvAxdhkjX9QoPHcO0x9q/3r9998b8ZPJn/r8xWyzZbqr8pfA9p1KLGW9e/g44Ebrly+5XCzLerVU8MPnz2oJPWzauV6fOTqfM7Kr+ZF82fTbzf4dpn2brs3Lk+39X2fHWiEztL05hoN4YdmTRurk/3Og87R9i9+W7N2+uZq3TbGrddGqKvf3LPHMrDBovmwZHlNObOP4l16XY90KZ7/x+SXx98lmRFJBjsTd8ubodTfLXDbedftg73vzHQUvFppXvH++1hKjf9uxAQ=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_best-time-to-buy-and-sell-stock-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [121. 买卖股票的最佳时机 🟢](/problems/best-time-to-buy-and-sell-stock)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>

