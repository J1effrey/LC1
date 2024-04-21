def removeElement(nums, val):
    """
    TC: O(2n)
    SC: O(1)
    """
    i = 0
    for j in range(0, len(nums)):
        if nums[j] != val:
            nums[i] = nums[j]
            i += 1
    return i