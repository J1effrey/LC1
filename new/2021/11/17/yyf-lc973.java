// yyf version
class Solution {
    Map<Integer, Integer> map;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] elements = new int[map.size()];
        int i = 0;
        for (int num : map.keySet()) {
            elements[i] = num;
            i++;
        }

        int n = elements.length;
        // here n - k so that n - k elements are at the start of the array and
		// the top k elements are pushed at the end of the array after quickselect
        quickSelect(elements, 0, n - 1, n - k);
        // from n - k to n as the top k elements are at the end of the array
        return Arrays.copyOfRange(elements, n - k, n);
    }

    // unlike quickSort, quickSelect traverses into one side – the side with the element it is searching for
    private void quickSelect(int[] a, int start, int end, int k) {
        while (start < end) {
            int pIndex = partition(a, start, end);
            if (pIndex < k) {
                start = pIndex + 1;
            } else if (pIndex > k) {
                end = pIndex - 1;
            } else {
                return;
            }
        }
    }

    // partition function is the same as in quick sort
    private int partition(int[] points, int l, int r) {
        int pivot = points[l];
        int i = l + 1;
        int j = r;
        while (i <= j) {
            while (i < r && map.get(points[i]) <= map.get(pivot)) i++;
            while (j > l && map.get(points[j]) >= map.get(pivot)) j--;
            if (i >= j) {
                break;
            }
            swap(points, i, j);
            i++;
            j--;
        }
        swap(points, l, j);
        return j;
        // int pivot = a[end];
        // int pIndex = start;
        // for (int i = start; i < end; i++) {
        //     if (map.get(a[i]) <= map.get(pivot)) {
        //         swap(a, i, pIndex);
        //         pIndex++;
        //     }
        // }
        // swap(a, pIndex, end);
        // return pIndex;
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
