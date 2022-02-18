// T:O(s) s is path length 
// S:O(s)
class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String directory : paths) {
            if (".".equals(directory) || directory.isEmpty()) {
                continue;
            } 
            if ("..".equals(directory) ){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(directory);
        }
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}

// ==========================================================
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        
        String[] strs = path.split("/+");
        List<String> list = new ArrayList<>();
        
        for (String s: strs) {
            if (s.equals("..") ) {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                list.add(s);
            }
        }
        
        String res = "/";
        
        for (String string: list) {
            res = res + string + "/";
        }
        
        return res.length() > 1 ? res.substring(0, res.length() - 1) : res;
    }
}
