func twoSum(nums []int, target int) []int {
    if nums == nil || len(nums) < 2 {
        return nil
    }
    
    numsMap := make(map[int]int)
    for idx, val := range nums {
        if prevIdx, ok := numsMap[val]; ok {
            return []int{prevIdx, idx}
        } 
        numsMap[target - val] = idx
    }
    return []int{}
}
