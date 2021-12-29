class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return 0;
        }
        
        if (cost == null || cost.length == 0) {
            return 0;
        }
        
        int deficit = 0;
        int total = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            
            if (total < 0) {
                deficit += total;
                start = i + 1;
                total = 0;
            }
        }
        
        return total + deficit >= 0 ? start : -1;
    }
}

==========
// same as above, use your own judgement to choose the one you like during interview    
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        
        if (cost == null || cost.length == 0) {
            return 0;
        }
        
        int debt = 0;
        int remain = 0;
        int startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int newRemain = remain + gas[i] - cost[i];
            if (newRemain < 0) {
                debt += -newRemain;
                startIndex = i + 1;
                remain = 0;
            } else {
                remain = newRemain;
            }
        }
        
        
        return remain >= debt ? startIndex : -1;
    }
}
