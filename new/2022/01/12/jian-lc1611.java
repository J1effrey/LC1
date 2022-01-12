class Solution {
    public int minimumOneBitOperations(int n) {
        String strn = Integer.toBinaryString(n);
        int len = strn.length();
        
        int[] cost = new int[len];//cost of "power of two" numbers
        cost[len-1] = 1;
        for(int i = len-2; i >= 0; i--)
            cost[i] = 2*cost[i+1]+1;
        
        int[] toZero = new int[len];//cost of changing the i-th bit and its lower bits to 0
        int[] toOne = new int[len];//cost of changing the i-th bit to 1 and its lower bits to 0
        if(strn.charAt(len-1) == '0')
            toOne[len-1] = 1;
        else
            toZero[len-1] = 1;
        
        for(int i = len-2; i >= 0; i--)
        {
            char c = strn.charAt(i);
            if(c == '0')
            {
                //current bit need to be set to 0, so compare the situation where previous operation set the (i+1)-th position (the lower bit) to 0 and 1
                toZero[i] = Math.min(toZero[i+1], toOne[i+1]+cost[i+1]);
                toOne[i] = Math.min(toOne[i+1]+1+cost[i+1], toZero[i]+cost[i]);
            }
            else
            {
                toZero[i] = Math.min(toZero[i+1]+cost[i], toOne[i+1]+1+cost[i+1]);
                toOne[i] = Math.min(toOne[i+1]+cost[i+1], toZero[i+1]);
            }
        }
        
        return toZero[0];
    }
}
