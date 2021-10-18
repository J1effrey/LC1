class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        int res = 1;
        
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> m = new HashMap<String, Integer>();
            int duplicates = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }
                
                int gcd = getGcd(dx, dy);
                dx = dx / gcd;
                dy = dy / gcd;
                String key = dx + " " + dy;
                
                if (m.containsKey(key)) {
                    int count = m.get(key);
                    count++;
                    m.put(key, count);
                    res = Math.max(res, count);
                } else {
                    m.put(key, 2);
                    res = Math.max(res, 2);
                }
            }
            
            res = res + duplicates;
        }
        
        return res;
    }
    
    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return getGcd(b, a % b);
    }
}

/*
y = ax + b;

slope : a 

ganrantee: 
point p, fixed a,  there will only one line 

p1 p2 p3 p4 p5 .. pn

p1 is fixed, pointer

iterate on p2,  slope : y2 - y1 / x2 - x1, go through p1, there will one line
iterate on p3, y3 - y1 / x3 - x1,  1) p3 is that p1 p2 line, 2) store a new slope
iterate on p4,  1) on previous line 2) a new slope.
1 / 3 = 0.33333333333333333333333;
accuracy problem in double, 

co prime of y2 - y1 / x2 - x1     15 / 30 gcd 15 2 / 4 3 / 6   -> 1 /2 
co prime: 

res max

*/
