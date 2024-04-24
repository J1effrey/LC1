<p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow-up:</strong> Could you solve the problem in linear time and in 
<code>O(1)</code> space?

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | Divide and Conquer | Sorting | Counting</details><br>

<div>👍 18755, 👎 594<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题的标准解法肯定是用一个哈希表作为计数器记录每个元素出现的次数，然后寻找出现次数最多的那个元素，时间和空间复杂度都是 `O(N)`。

但是由于题目说了这个目标元素（众数）出现的次数**过半**，这就有意思了，其实我们不需要用哈希表来做计数器就能把这个众数找出来。

你想象一下，比方说一群带正电的粒子和一群带负电的粒子，把它们混合起来，得到的这群混合粒子的带电性质是什么？这取决于正电离子多还是负电离子多，如果正负粒子数量恰好相等，则呈电中性。

回到这道题，题目告诉你一定存在一个众数，它出现的次数过半，那么如果你把这个众数元素想象成正电粒子，其他的所有元素都想象成负电粒子，那么它们混合起来会怎样？

**在正负粒子混合的过程中，整体的带电性可能在正负间波动，但最终的结果一定是正电**。

有了这个类比，你看下解法代码，我们是如何用 `O(1)` 的空间复杂度来计算众数的。

**标签：哈希表，[数组](https://labuladong.online/algo/)**

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
    int majorityElement(vector<int>& nums) {
        // 我们想寻找的那个众数
        int target = 0;
        // 计数器（类比带电粒子例子中的带电性）
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                // 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i];
                // 众数出现了一次
                count = 1;
            } else if (nums[i] == target) {
                // 如果遇到的是目标众数，计数器累加
                count++;
            } else {
                // 如果遇到的不是目标众数，计数器递减
                count--;
            }
        }
        // 回想带电粒子的例子
        // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 我们想寻找的那个众数
        target = 0
        # 计数器（类比带电粒子例子中的带电性）
        count = 0
        for i in range(len(nums)):
            if count == 0:
                # 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i]
                # 众数出现了一次
                count = 1
            elif nums[i] == target:
                # 如果遇到的是目标众数，计数器累加
                count += 1
            else:
                # 如果遇到的不是目标众数，计数器递减
                count -= 1
        # 回想带电粒子的例子
        # 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int majorityElement(int[] nums) {
        // 我们想寻找的那个众数
        int target = 0;
        // 计数器（类比带电粒子例子中的带电性）
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                // 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i];
                // 众数出现了一次
                count = 1;
            } else if (nums[i] == target) {
                // 如果遇到的是目标众数，计数器累加
                count++;
            } else {
                // 如果遇到的不是目标众数，计数器递减
                count--;
            }
        }
        // 回想带电粒子的例子
        // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func majorityElement(nums []int) int {
    // 我们想寻找的那个众数
    target := 0
    // 计数器（类比带电粒子例子中的带电性）
    count := 0
    for i := 0; i < len(nums); i++ {
        if count == 0 {
            // 当计数器为 0 时，假设 nums[i] 就是众数
            target = nums[i]
            // 众数出现了一次
            count = 1
        } else if nums[i] == target {
            // 如果遇到的是目标众数，计数器累加
            count++
        } else {
            // 如果遇到的不是目标众数，计数器递减
            count--
        }
    }
    // 回想带电粒子的例子
    // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
    return target
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var majorityElement = function(nums) {
    // 我们想寻找的那个众数
    let target = 0;
    // 计数器（类比带电粒子例子中的带电性）
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        if (count === 0) {
            // 当计数器为 0 时，假设 nums[i] 就是众数
            target = nums[i];
            // 众数出现了一次
            count = 1;
        } else if (nums[i] === target) {
            // 如果遇到的是目标众数，计数器累加
            count++;
        } else {
            // 如果遇到的不是目标众数，计数器递减
            count--;
        }
    }
    // 回想带电粒子的例子
    // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
    return target;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_majority-element" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_majority-element"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 39. 数组中出现次数超过一半的数字 🟢](/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof)

</details>
</div>

