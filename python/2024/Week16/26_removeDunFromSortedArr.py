def removeDuplicates(self, nums):
    """
    TC: O(n)
    SC: O(1)
    """
    i = 0
    j = 0
    prev = -101
    while j < len(nums):
        if nums[j] != prev:
            nums[i] = nums[j]
            i += 1
            prev = nums[j]
        else:
            j += 1

    return i