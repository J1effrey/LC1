// T: O(V+E)
// S: O(V+E)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[0];
        }
        
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            inDegree[post]++;
            List<Integer> posts = map.getOrDefault(pre, new ArrayList<>());
            posts.add(post);
            map.put(pre, posts);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;
            if (map.containsKey(course)) {
                for (Integer n : map.get(course)) {
                    if(--inDegree[n] == 0) {
                        queue.offer(n);
                    }
                }
            }
        }
        
        return index == numCourses ? res : new int[0];
    }
}
