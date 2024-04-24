
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        idxMap = {}
        for i in range(0, len(nums)):
            n = nums[i]
            if n in idxMap:
                return [idxMap[n], i]
            idxMap[target - n] = i
        return []
# leetcode submit region end(Prohibit modification and deletion)
