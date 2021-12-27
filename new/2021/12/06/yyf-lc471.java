// DP
class Solution {
    public String encode(String s) {
        int n = s.length();
    	String[][] dp = new String[n][n];
    	for(int len = 1; len <= n; ++len) {		//枚举区间长度
    		for(int i = 0; i + len - 1 < n; ++i) {		//枚举起点
    			int j = i + len - 1;					//计算终点
    			dp[i][j] = s.substring(i,  j + 1);
    			for(int k = i; k < j; ++k) {			//利用k分割出左部分和右部分
    				if(dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {  //如果左右两侧长度和小于当前答案就更新
    					dp[i][j] = dp[i][k] + dp[k + 1][j];
    				}
    			}
    			String now = s.substring(i, j + 1);  	//截取当前区间
    			int st = (now + now).indexOf(now, 1);  //1表示从拼接的字符串首字母后开始查找
    			if(st < now.length()) {    //如果区间内包含重复字符串，则返回的起点不会超过区间
                    now = String.valueOf(now.length() / st) + "[" + dp[i][i + st - 1] + "]";    //计算字符串前的数字即题面中的k
                }
    			if(now.length() < dp[i][j].length())dp[i][j] = now;  //如果长度更小就进行更新
    		}
    	}
    	return dp[0][n - 1];
    }
}

/*=============================================================================================================================================================================*/
// DFS
class Solution {
    Map<String, String> map = new HashMap<>();
    public String encode(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() <= 4) {
            return s;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        String res = s;
        for (int i = s.length() / 2; i < s.length(); i++) {
            String pattern = s.substring(i);
            int count = countPatterns(s, pattern);
            if (count == -1) {
                continue;
            }
            String candidate = count + "[" + encode(pattern) + "]";
            if (candidate.length() < res.length()) {
                res = candidate;
            }
        }
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            String candidate = encode(left) + encode(right);
            if (candidate.length() < res.length()) {
                res = candidate;
            }
        }
        map.put(s, res);
        return res;
    }
    
    public int countPatterns(String s, String p) {
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.substring(i).startsWith(p)) {
                i += p.length();
                count++;
            } else {
                return -1;
            }
        }
        return count * p.length() == s.length() ? count : -1;
    }
}

/*
s.length() <= 4 return s;
aabcaabc
aabc aabc
2[aabc]
*/
