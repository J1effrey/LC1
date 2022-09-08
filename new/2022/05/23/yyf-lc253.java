// T:O(NlogN)
// S:O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0]- b[0]);
        int res = 0;
        int count = 0;
        for (int[] point : list) {
            count += point[1];
            res = Math.max(res, count);
        }
        return res;
    }
}



// 变种扫描线
public int minMeetingRooms(int[][] intervals) {
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
        starts[i] = intervals[i][0];
        ends[i] = intervals[i][1];
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int room = 0;
    int end = 0;
    for (int i = 0; i < starts.length; i++) {
        room++;
        if (ends[end] <= starts[i]) {
            room--;
            end++;
        }
    }
    return room;
}
