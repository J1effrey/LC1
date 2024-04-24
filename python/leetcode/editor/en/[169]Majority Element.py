# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        return self.solution2(nums)


    """
    1. sort
    TC: O(nlogn)
    SC: O(n)
    """
    def solution1(self, nums: list[int]) -> int:
        nums.sort()
        idx = int(len(nums) / 2)
        return nums[idx]

    """
       2. majority reduce
       TC: O(n)
       SC: O(1)
       """
    def solution2(self, nums: list[int]) -> int:
        currMajor = 0
        currCnt = 0
        for n in nums:
            if n == currMajor:
                currCnt += 1
            else:
                if currCnt == 0:
                    currMajor = n
                    currCnt = 1
                else:
                    currCnt -= 1
        return currMajor
# leetcode submit region end(Prohibit modification and deletion)
