class Solution {
    // 注意这里返回的是翻转的index，我们找最大翻转到top，再次翻转到bottom，翻转两次
    // 所以我们记录两次翻转的index到result当中。并不是返回sorted后的结果
    // 每次翻转是前K个 arr[i] is a permutation of [1, 2, ..., arr.length]
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int N = arr.length;
        int largest = N;
        for (int i = 0; i < N; i++) {
            int index = find(arr, largest);
            flip(arr, index);       // 目标位置调整到了arr[0]
            flip(arr, largest - 1); // 最大值位置调整到了最后面正确的位置
            result.add(index + 1);  // 前k个需要把index=0计算进去，所以+1
            result.add(largest--);  // 两步res.add()都是记录flip位置
            // 因为之前是前index被反转，最大值为arr[0]，所以还是前index反转到后面
        }
        return result;
    }
    
    public int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    
    public void flip(int[] arr, int index) {
        int i = 0;
        int j = index;
        while (i < j) {
            int tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }
}
