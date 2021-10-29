class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return 0;
        }
        int total = 0;
        int def = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                start = i + 1;
                def += total;
                total = 0;
            }
        }
        return total + def >= 0 ? start : -1;
    }
}
