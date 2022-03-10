//Time: O(1)
//Space: O(n)
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


// follow up 大规模
class HitCounter {
    LinkedList<Integer> queueTimestamp = new LinkedList<>();
    HashMap<Integer, Integer> freq = new HashMap<>();
    int hitCount = 0;

    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (!queueTimestamp.isEmpty() && queueTimestamp.peekLast() == timestamp) { // 2(2) 3 301
            freq.put(timestamp, freq.get(timestamp) + 1);
        } else {
            freq.put(timestamp, 1);
            queueTimestamp.addLast(timestamp);
        }
        hitCount++;
        rollOutOldData(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        rollOutOldData(timestamp);
        return hitCount;
    }
    
    void rollOutOldData(int timestamp) {
        while (!queueTimestamp.isEmpty() && timestamp - queueTimestamp.peek() + 1 > 300) {
            int victim = queueTimestamp.poll();
            hitCount -= freq.get(victim);
            freq.remove(victim);
        }
    }
}
/*
Linkedlist: 
HashMap:
*/
