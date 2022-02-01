//Time: O(1)
//Space: O(n)
class Logger {
    Map<String, Integer> m;
    public int COOL_DOWN_TIME = 10;
    public Logger() {
        m = new HashMap<String, Integer>();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!m.containsKey(message)) {
            m.put(message, timestamp);
            return true;
        }
        
        if (timestamp - m.get(message) >= COOL_DOWN_TIME) {
            m.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
