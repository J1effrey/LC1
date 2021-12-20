class HitCounter {
    
    Queue<Integer> queue;
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
