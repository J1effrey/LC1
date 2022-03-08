// T:O(s) s is path length 
// S:O(s)

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        
        String[] splited = path.split("/+");
        LinkedList<String> paths = new LinkedList<>();
        
        for (int i = 0; i < splited.length; i++) {
            String curPath = splited[i];
            if (curPath.equals(".") || curPath.isEmpty()) {
                continue;
            }
            
            if (curPath.equals("..")) {
                if (paths.size() > 0) {
                    paths.removeLast();
                }
                continue;
            }  
            paths.add(curPath);
        }
        
        StringBuilder sb = new StringBuilder("/");
        
        for (int i = 0; i < paths.size(); i++) { 
            sb.append(paths.get(i));
            if (i < paths.size() - 1) {
                sb.append('/');
            }
        }
        
        return sb.toString();
    }
}

===========================================

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


