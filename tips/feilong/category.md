__(必背：紫色；核心：蓝色；重点：绿色；普通：黄色；默认是LeetCode，如果是LintCode会以Lint开头)__

# 目录

- 第一章 二分法
  - [朴素二分法](#朴素二分法)
  - [条件二分法](#条件二分法)
  - [答案二分法](#答案二分法)
- 第二章 多指针
  - [数组](#数组)
  - [链表](#链表)
  - [区间](#区间)
  - [回文串](#回文串)
  - [滑动窗口](#滑动窗口)
  - [流](#流)
  - [前项和](#前项和)
  - [和差问题](#和差问题)
- 第三章 BFS
  - [二叉树](#二叉树)
  - [拓扑排序](#拓扑排序)
  - [矩阵](#矩阵)
  - [图](#图)
- 第四章 二叉树与递归
  - [二叉树前中后顺遍历](#二叉树前中后序遍历-需要熟练掌握非递归方式)
  - [反向复原二叉树](#反向复原二叉树)
  - [iterator相关](#iterator相关)
  - [判断树的形态](#判断树的形态)
  - [子树相关问题](#子树相关问题)
  - [路径相关问题](#路径相关问题)
  - [LCA问题](#LCA问题)
  - [其他](#其他)
- 第五章 DFS
  - [排列组合](#排列组合)
  - [二叉树](#二叉树)
  - [图](#图2)
- 第六章 数据结构
  - [Array & Matrix](#Array-and-Matrix)
  - [String](#String)
  - [LinkedList](#Linked-List)
  - [Hash](#Hash)
  - [Stack](#Stack)
  - [Monotonic Stack](#Monotonic-Stack)
  - [Trie](#Trie)
  - [Union Find](#Union-Find)
  - [Sweep Line](#Sweep-Line)
  - [Binary Index Tree & Segment Tree](#Binary-Index-Tree-and-Segment-Tree)
  - [Complex Data Structure](#Complex-Data-Structure)
- 第七章 动态规划
  - [Backpack](#Backpack)
  - [Single Sequence](#Single-Sequence-单序列型)
  - [Double Sequences](#Double-Sequences-双序列型)
  - [Sections](#Sections)
  - [Matrix](#Matrix-坐标型)
  - [Others](#Others)
  - [Greedy](#Greedy)
- 第八章 其他方法
  - [backTrack](#BackTrack)
  - [TopK]()




-----

# 第一章 二分法

## 朴素二分法

- [704. Binary Search](https://leetcode.com/problems/binary-search/)
- [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
- [702. Search in a Sorted Array of Unknown Size](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
- [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
- [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)
- [278. First Bad Version](https://leetcode.com/problems/first-bad-version/)
- [658. Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)



## 条件二分法

- [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
- [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)
- [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)
- [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)
- [302. Smallest Rectangle Enclosing Black Pixels](https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/)
- [852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

## 答案二分法

- [875.Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
- [1283. Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)
- [69. Sqrt(x)](https://leetcode.com/problems/sqrtx/)
- [Lint-586. Sqrt(x) II, follow up](https://www.lintcode.com/problem/sqrtx-ii/description)
- [Lint-183. Wood Cut](https://www.lintcode.com/problem/wood-cut/description)
- [Lint-437. Copy Books](https://www.lintcode.com/problem/copy-books/description)
- [Lint-438. Copy Books II](https://www.lintcode.com/problem/copy-books-ii/description)



------

# 第二章 多指针



## 数组

- [912. Sort an Array (Quick Sort and Merge Sort)](https://leetcode.com/problems/sort-an-array/)
- [75. Sort Colors](https://leetcode.com/problems/sort-colors/)
- [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
- [80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
- [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
- [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)
- [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)
- [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)
- [845. Longest Mountain in Array](https://leetcode.com/problems/longest-mountain-in-array/)
- [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
- [43. Multiply Strings](https://leetcode.com/problems/multiply-strings/)
- [969. Pancake Sorting](https://leetcode.com/problems/pancake-sorting/)
- [Lint-31. Partition Array](https://www.lintcode.com/problem/partition-array/description)
- [Lint-625. Partition Array II](https://www.lintcode.com/problem/partition-array-ii/description)
- [Lint-143. Sort Color II](https://www.lintcode.com/problem/sort-colors-ii/description)
- [Lint-461. Kth Smallest Numbers in Unsorted Array](https://www.lintcode.com/problem/461/)
- [Lint-544. Top k Largest Numbers](https://www.lintcode.com/problem/544/)



## 链表

- [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [86. Partition List](https://leetcode.com/problems/partition-list/)
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)
- [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
- [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
- [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)
- [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)



## 区间

- [Lint-391. Number of Airplanes in the Sky](https://www.lintcode.com/problem/391/)
- [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [57. Insert Interval](https://leetcode.com/problems/insert-interval/)
- [252. Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
- [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
- [986. Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/)



## 回文串

- [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
- [345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)
- [680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)
- [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)



## 滑动窗口

- [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
- [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
- [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
- [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
- [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)
- [395. Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)
- [480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/)
- [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)
- [727. Minimum Window Subsequence](https://leetcode.com/problems/minimum-window-subsequence/)
- [Lint-604. Window Sum](https://www.lintcode.com/problem/window-sum/description)



## 流

- [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
- [346. Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/)
- [352. Data Stream as Disjoint Intervals](https://leetcode.com/problems/data-stream-as-disjoint-intervals/)
- [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)



## 前项和

- [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
- [303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
- [325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
- [528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)
- [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)



## 和差问题

- [1. Two Sum](https://leetcode.com/problems/two-sum/)
- [15. 3Sum](https://leetcode.com/problems/3sum/)
- [18. 4Sum](https://leetcode.com/problems/4sum/)
- [Lint-382. Triangle Count](https://www.lintcode.com/problem/triangle-count/description)
- [167. Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [170. Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design/)
- [653. Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)
- [1099. Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/)
- [259. 3Sum Smaller](https://leetcode.com/problems/3sum-smaller/)
- [Lint-57. 3Sum Closest](https://www.lintcode.com/problem/3sum-closest/description)
- [Lint-443. Two Sum - Greater than target](https://www.lintcode.com/problem/443/)
- [Lint-533. Two Sum - Closet to target](https://www.lintcode.com/problem/533/)
- [Lint-587. Two Sum - Unique pairs](https://www.lintcode.com/problem/two-sum-unique-pairs/description)
- [Lint-609. Two Sum - Less than or equals to target](https://www.lintcode.com/problem/609/)
- [Lint-610. Two Sum - Difference equals to target](https://www.lintcode.com/problem/two-sum-difference-equals-to-target/my-submissions)



-------

# 第三章 宽度优先搜索



## 二叉树

- [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
- [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
- [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
- [107, Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
- [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)
- [Lint-242. Convert Binary Tree to Linked Lists by Depth](https://www.lintcode.com/problem/242/)



## 拓扑排序

- [Lint-127. Topological Sorting](https://www.lintcode.com/problem/topological-sorting/description)
- [207. Course Schedule](https://leetcode.com/problems/course-schedule/)
- [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
- [269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)
- [444. Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)



## 矩阵

- [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
- [490. The Maze](https://leetcode.com/problems/the-maze/)
- [505. The Maze II](https://leetcode.com/problems/the-maze-ii/)
- [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)
- [733. Flood Fill](https://leetcode.com/problems/flood-fill/)
- [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
- [305. Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/)
- [773. Sliding Puzzle](https://leetcode.com/problems/sliding-puzzle/)
- [Lint-573. Build Post Office II](https://www.lintcode.com/problem/build-post-office-ii/description)
- [Lint-598. Zombie in Matrix](https://www.lintcode.com/problem/zombie-in-matrix/description)
- [Lint-611. Knight Shortest Path](https://www.lintcode.com/problem/knight-shortest-path/description)
- [Lint-794. Sliding Puzzle II](https://www.lintcode.com/problem/sliding-puzzle-ii/description)



## 图

- [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
- [127. Word Ladder](https://leetcode.com/problems/word-ladder/)
- [261. Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
- [841. Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)
- [323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- [1306. Jump Game III](https://leetcode.com/problems/jump-game-iii/)
- [Lint-531. Six Degree](https://www.lintcode.com/problem/six-degrees/description)
- [Lint-618. Search Graph Nodes](https://www.lintcode.com/problem/search-graph-nodes/description)
- [Lint-624. Remove Substrings](https://www.lintcode.com/problem/remove-substrings/description)





--------

# 第四章 二叉树与递归

因为二叉树上的递归很多时候既可以用分治，也可以用遍历，并不是哪一种方法总能最优。
所以我们按相似题目分类，而不是按解法分类。



## 二叉树前中后序遍历 需要熟练掌握非递归方式

- [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)
- [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)



## 反向复原二叉树

- [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
- [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
- [889. Construct Binary Tree from Preorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)



## Iterator相关

- [173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)
- [280. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
- [285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst/)
- [270. Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value/)
- [272. Closest Binary Search Tree Value II](https://leetcode.com/problems/closest-binary-search-tree-value-ii/)
- [510. Inorder Successor in BST II](https://leetcode.com/problems/inorder-successor-in-bst-ii/)
- [Lint-915. Inorder Predecessor in BST II](https://www.lintcode.com/problem/915/)

## 判断树的形态

- [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
- [100. Same Tree](https://leetcode.com/problems/same-tree/)
- [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
- [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)



## 子树相关问题

- [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [333. Largest BST Subtree](https://leetcode.com/problems/largest-bst-subtree/)
- [Lint-596. Minimum Subtree](https://www.lintcode.com/problem/minimum-subtree/description)
- [Lint-597. Subtree with Maximum Average](https://www.lintcode.com/problem/597/)



## 路径相关问题

- [112. Path Sum](https://leetcode.com/problems/path-sum/)
- [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)
- [124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
- [Lint-475. Binary Tree Maximum Path Sum II](https://www.lintcode.com/problem/475/)
- [298. Binary Tree Longest Consecutive Sequence](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/)
- [549. Binary Tree Longest Consecutive Sequence II](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/)
- [Lint-619. Binary Tree Longest Consecutive Sequence III](https://www.lintcode.com/problem/619/)



## LCA问题

- [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [Lint-474. Lowest Common Ancestor II](https://www.lintcode.com/problem/474/)
- [Lint-578. Lowest Common Ancestor III](https://www.lintcode.com/problem/lowest-common-ancestor-iii/solution)

## 其他

- [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)
- [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)
- [331. Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/)
- [449. Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/)
- [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)



-------------

# 第五章 深度优先搜索



## 排列组合

- [39. Combination Sum](https://leetcode.com/problems/combination-sum/)   [:boat:](https://leetcode.com/problems/combination-sum/)
- [40. Combination Sum II ](https://leetcode.com/problems/combination-sum-ii/)     [:bomb:](https://leetcode.com/problems/combination-sum-ii/)    
- [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii)    [:book:](https://leetcode.com/problems/combination-sum-iii)   
- [377. Combination Sum IV](https://leetcode.com/problems/combination-sum-iv)   [:bookmark:](https://leetcode.com/problems/combination-sum-iv)
- [46. Permutations](https://leetcode.com/problems/permutations/)   [:bookmark_tabs:](https://leetcode.com/problems/permutations/)
- [47. Permutations II](https://leetcode.com/problems/permutations-ii/)  [:books:](https://leetcode.com/problems/permutations-ii/)
- [77. Combinations](https://leetcode.com/problems/combinations/)     [:boom:](https://leetcode.com/problems/combinations/)   
- [78. Subsets](https://leetcode.com/problems/subsets/)   [:boot:](https://leetcode.com/problems/subsets/)
- [90. Subsets II](https://leetcode.com/problems/subsets-ii/)   [:bouquet:](https://leetcode.com/problems/subsets-ii/)
- [17. Letter Combinations of a Phone Number ](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)  [:bow:](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
- [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)   [:bow_and_arrow:](https://leetcode.com/problems/generate-parentheses/)
- [51. N-Queens](https://leetcode.com/problems/n-queens/)     [:bowing_man:](https://leetcode.com/problems/n-queens/)   
- [52. N-Queens II](https://leetcode.com/problems/n-queens-ii/)   [:bowing_woman:](https://leetcode.com/problems/n-queens-ii/)
- [254. Factor Combinations](https://leetcode.com/problems/factor-combinations/)   [:bowling:](https://leetcode.com/problems/factor-combinations/)
- [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)
- [491. Increasing Subsequences](https://leetcode.com/problems/increasing-subsequences/)   [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)
- [37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)
- [93. Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)
- [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)
- [Lint-10. String Permutation II](https://www.lintcode.com/problem/10/)
- [Lint-570. Find the Missing Number II](https://www.lintcode.com/problem/570/)
- [Lint-680. Split String](https://www.lintcode.com/problem/split-string/description)



## 二叉树

- [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)
- [257. Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)
- [Lint-246. Binary Tree Path Sum II](https://www.lintcode.com/problem/binary-tree-path-sum-ii/solution)
- [Lint-376. Binary Tree Path Sum](https://www.lintcode.com/problem/binary-tree-path-sum/solution)
- [Lint-472. Binary Tree Path Sum III](https://www.lintcode.com/problem/472/)



## 图2

- [140. Word Break II](https://leetcode.com/problems/word-break-ii/)
- [494. Target Sum](https://leetcode.com/problems/target-sum/)
- [1192. Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/)
- [126. Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)
- [290. Word Pattern](https://leetcode.com/problems/word-pattern/)
- [291. Word Pattern II](https://leetcode.com/problems/word-pattern-ii/)





----------

# 第六章 数据结构



## Number

- [29. Divide Two Integers](../../topics/lc29.java)   [:bamboo:](

## Array and Matrix

- [442. Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)
- [48. Rotate Image](https://leetcode.com/problems/rotate-image/)
- [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)
- [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)
- [289. Game of Life](https://leetcode.com/problems/game-of-life/)





## String

- [6. ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)
- [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
- [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
- [68. Text Justification](https://leetcode.com/problems/text-justification/)
- [443. String Compression](https://leetcode.com/problems/string-compression/)





## Linked List

- [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
- [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)
- [82. Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
- [83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
- [86. Partition List](https://leetcode.com/problems/partition-list/)
- [92.Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)
- [138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [148. Sort List](https://leetcode.com/problems/sort-list/)
- [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)
- [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
- [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
- [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
- [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
- [445. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)
- [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [876.Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)



## Hash

- [706. Design HashMap](https://leetcode.com/problems/design-hashmap/)
- [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
- [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
- [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
- [953. Verifying an Alien Dictionary](https://leetcode.com/problems/verifying-an-alien-dictionary/)
- [290. Word Pattern](https://leetcode.com/problems/word-pattern/)



## Heap

- [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
- [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)
- [767. Reorganize String](https://leetcode.com/problems/reorganize-string/)
- [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
- [480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/)
- [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)



## Stack

- [155. Min Stack](https://leetcode.com/problems/min-stack/)
- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [224. Basic Calculator](https://leetcode.com/problems/basic-calculator/)
- [227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)
- [394. Decode String](https://leetcode.com/problems/decode-string/)
- [1249. Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)





## Monotonic Stack

- [300. Longest Increasing Subsequence (Patience Sort)](https://leetcode.com/problems/longest-increasing-subsequence/)
- [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
- [85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)
- [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
- [1019. Next Greater Node In Linked List](https://leetcode.com/problems/next-greater-node-in-linked-list/)



## Trie

- [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
- [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
- [1032. Stream of Characters](https://leetcode.com/problems/stream-of-characters/)



## Union Find

- [305. Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/)
- [323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- [128. Longest Consecutive Sequence(Union Find)](../../topics/lc128.java)  [:blossom:](https://leetcode.com/problems/longest-consecutive-sequence)
- [200. Number of Islands(Union Find)](../../topics/lc200.java)    [:black_square_button:](https://leetcode.com/problems/number-of-islands) 
- [695. Max Area of Island(Union Find)](../../topics/lc695.java)  [:blonde_man:](https://leetcode.com/problems/max-area-of-island)
- [721. Accounts Merge(Union Find)](../../topics/lc721.java)  [:blonde_woman:](https://leetcode.com/problems/accounts-merge)



## Sweep Line

- [Lint-391. Number of Airplanes in the Sky](https://www.lintcode.com/problem/391/)
- [252. Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
- [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)



## Binary Index Tree and Segment Tree

- [307. Range Sum Query - Mutable](https://leetcode.com/problems/range-sum-query-mutable/)
- [327. Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/)
- [715. Range Module](https://leetcode.com/problems/range-module/)
- [315. Count of Smaller Numbers After Self](https://leetcode.com/problems/co ... numbers-after-self/)
- [493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)



## Complex Data Structure

- [146. LRU Cache](https://leetcode.com/problems/lru-cache/)
- [460. LFU Cache](https://leetcode.com/problems/lfu-cache/)
- [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
- [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)
- [528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)
- [588. Design In-Memory File System](https://leetcode.com/problems/design-in-memory-file-system/)
- [981. Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)
- [1396. Design Underground System](https://leetcode.com/problems/design-underground-system/)



----------

# 第七章 动态规划



## Backpack

- [Lint-92. Backpack](https://www.lintcode.com/problem/backpack/description)
- [Lint-125. Backpack II](https://www.lintcode.com/problem/backpack-ii/description)
- [Lint-440. Backpack III](https://www.lintcode.com/problem/backpack-iii/description)
- [Lint-562. Backpack IV](https://www.lintcode.com/problem/backpack-iv/description)
- [Lint-563. Backpack V](https://www.lintcode.com/problem/backpack-v/description)
- [Lint-564. Backpack VI (Combination Sum IV)](https://www.lintcode.com/problem/combination-sum-iv/description)
- [Lint-971. Surplus Value Backpack](https://www.lintcode.com/problem/971/)
- [474. Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/)



## Single Sequence 单序列型

- [139. Word Break](https://leetcode.com/problems/word-break/)
- [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
- [123. Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
- [188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
- [132. Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)
- [256. Paint House](https://leetcode.com/problems/paint-house/)
- [265. Paint House II](https://leetcode.com/problems/paint-house-ii/)
- [Lint-843. Digital Flip](https://www.lintcode.com/problem/digital-flip/description)



## Double Sequences 双序列型

- [10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)
- [44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)
- [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
- [72. Edit Distance](../../topics/lc72.java)   [:one:](https://leetcode.com/problems/edit-distance/)  
- [97. Interleaving String](https://leetcode.com/problems/interleaving-string/)
- [115. Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)

  

## Sections

- [312.Burst Balloons](https://leetcode.com/problems/burst-balloons/)
- [516.Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
- [87.Scramble String](https://leetcode.com/problems/scramble-string/)



## Matrix 坐标型

- Jump Game
- LIS
- [62. Unique Paths](https://leetcode.com/problems/unique-paths/)
- [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)
- [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
- [85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)
- [221. Maximal Square](https://leetcode.com/problems/maximal-square/)
- [361. Bomb Enemy](https://leetcode.com/problems/bomb-enemy/)



## Others

- [91. Decode Ways](https://leetcode.com/problems/decode-ways/)
- [Lint-394. Coins in a Line](https://www.lintcode.com/problem/coins-in-a-line/description)
- [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/)
- [639. Decode Ways II](https://leetcode.com/problems/decode-ways-ii/)
- [Lint-395. Coins in a Line II](https://www.lintcode.com/problem/coins-in-a-line-ii/description)
- [Lint-396. Coins in a Line III](https://www.lintcode.com/problem/coins-in-a-line-iii/description)

## Greedy

- [55. Jump Game](https://leetcode.com/problems/jump-game/)
- [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/)
- [763. Partition Labels](https://leetcode.com/problems/partition-labels/)



# 第八章 其他方法

## BackTrack

- [Subsets](https://leetcode.com/problems/subsets)
- [Subsets II](https://leetcode.com/problems/subsets-ii)
- [Permutations](https://leetcode.com/problems/permutations/)
- [Permutations II](https://leetcode.com/problems/permutations-ii/)
- [Combinations](https://leetcode.com/problems/combinations/)
- [39. Combination Sum](../../topics/lc39.java)   [:two:](https://leetcode.com/problems/combination-sum)
- [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)
- [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)
- [Palindrome Partition](https://leetcode.com/problems/palindrome-partitioning/)

## Top K

- [692. Top K Frequent Words](../../topics/lc692.java)   [:blossom:](https://leetcode.com/problems/top-k-frequent-words)
