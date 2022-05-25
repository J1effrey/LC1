class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                pq.add(interval);
            }
        }
        Interval cur = pq.poll();
        while (!pq.isEmpty()) {
            if (cur.end >= pq.peek().start) {
                cur.end = Math.max(cur.end, pq.poll().end);
            } else {
                res.add(new Interval(cur.end, pq.peek().start));
                cur = pq.poll();
            }
        }
        return res;
    }
}
