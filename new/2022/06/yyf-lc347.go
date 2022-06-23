func topKFrequent(nums []int, k int) []int {
    if (nums == nil || len(nums) == 0 || k <= 0) {
        return []int{}
    }

    res := make([]int, k)
    frequency := make(map[int]int)
    for _, num := range nums {
        frequency[num]++
    }

    uniqueNums := make([]int, len(frequency))
    index := 0
    for key, _ := range frequency {
        uniqueNums[index] = key
        index++
    }

    partition(uniqueNums, 0, len(uniqueNums) - 1, k - 1, frequency)

    for i := 0; i < k; i++ {
        res[i] = uniqueNums[i]
    }
    
    return res
}

func partition(nums []int, start int, end int, k int, frequency map[int]int) {
    if start == end {
        return
    }
        
    left := start
    right := end
    pivot := nums[(left + right) / 2]
    
    for left <= right {
        for left <= right && frequency[nums[left]] > frequency[pivot] {
            left++
        }

        for left <= right && frequency[nums[right]] < frequency[pivot] {
            right--
        }

        if left <= right {
            swap(nums, left, right)
            left++
            right--
        }
    }

    if k <= right {
        partition(nums, start, right, k, frequency)
    }

    if k >= left {
        partition(nums, left, end, k, frequency)
    }
}

func swap(nums []int, a int, b int) {
    nums[a], nums[b] = nums[b], nums[a]
}
