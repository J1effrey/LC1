func moveZeroes(nums []int)  {
    if (nums == nil || len(nums) == 0) {
        return
    }
    
    left := 0
    right := 0
    
    for ; right < len(nums); right++ {
        if (nums[right] != 0) {
            nums[left], nums[right] = nums[right], nums[left]
            left++
        }
    }
}
