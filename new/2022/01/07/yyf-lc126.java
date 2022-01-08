public class Solution {
    
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, List<String> list) {
        List<List<String>> res = new ArrayList<>();
        if (start == null || end == null || list == null || list.size() == 0) {
            return res;
        }
        Set<String> dict = new HashSet<>(list);        
        if (!dict.contains(end)) {
            return res;
        }
        
        Map<String, HashSet<String>> word2Neighbors = new HashMap<>();
        dict.add(start);
        dict.add(end);
        genNeighbors(dict, start, word2Neighbors);
        genNeighbors(dict, end, word2Neighbors);

        //init double-end bfs
        Node src = new Node(start);
        Node target = new Node(end);
        Queue<Node> forwardQueue = new LinkedList<>();
        Queue<Node> backendQueue = new LinkedList<>();
        Set<String> visitedForward = new HashSet<>();
        Set<String> visitedBackward = new HashSet<>();
        forwardQueue.offer(src);
        backendQueue.offer(target);
        visitedForward.add(start);
        visitedBackward.add(end);

        //双宽搜
        boolean flip = false; //是否为从end到start方向？
        while (!forwardQueue.isEmpty() && !backendQueue.isEmpty()) {
            List<Node> found = flip ?
                    extendQueue(dict, word2Neighbors, backendQueue, visitedBackward, visitedForward) :
                    extendQueue(dict, word2Neighbors, forwardQueue, visitedForward, visitedBackward) ;


            if (!found.isEmpty()) genRes(res, found, flip ? forwardQueue : backendQueue, flip);
            flip = !flip;
        }

        return res;
    }

    /**
     * 根据相遇时的情况生成结果集；这里要注意的是因为取的found实则为最后一次搜索扩展，因此必然包含在另一端的当前队列queueOp中，根据flipped旗标进行一次舍值。
     * @param res
     * @param found
     * @param queueOp
     * @param flipped
     */
    private void genRes(List<List<String>> res, List<Node> found, Queue<Node> queueOp, boolean flipped) {
        while (!queueOp.isEmpty()) {
            Node op = queueOp.poll();

            for (Node node : found) {
                if(!node.val.equals(op.val)) continue;

                Node forwardNode = flipped ? op : node;
                Node backwardNode = flipped ? node : op;

                if(flipped) forwardNode = forwardNode.pre; //注意此处舍值，如果为翻转方向，则用来回溯forward的节点需要倒退一格；反之另一边倒退一格。
                else backwardNode = backwardNode.pre;

                List<String> path = extendToPath(forwardNode, backwardNode);
                res.add(path);
            }
        }
    }

    /**
     * 将两边相遇的节点非别回溯生成完整path （todo: 考虑优化）
     * @param forwardNode
     * @param backwardNode
     * @return
     */
    private List<String> extendToPath(Node forwardNode, Node backwardNode) {
        List<String> path = new ArrayList<>();
        while (forwardNode != null) {
            path.add(forwardNode.val);
            forwardNode = forwardNode.pre;
        }
        Collections.reverse(path);

        while (backwardNode != null) {
            path.add(backwardNode.val);
            backwardNode = backwardNode.pre;
        }
        return path;
    }


    /**
     * 扩展当前层级，并将符合要求的下一层节点作为结果返回。
     * @param dict
     * @param word2Neighbors
     * @param queue 当前扩展方向下的队列
     * @param visitedSelf
     * @param visitedOp
     * @return
     */
    private List<Node> extendQueue(Set<String> dict, Map<String, HashSet<String>> word2Neighbors, Queue<Node> queue, Set<String> visitedSelf, Set<String> visitedOp) {
        List<Node> cands = new ArrayList<>();
        Set<String> newVisited = new HashSet<>(); //这里一定要注意与visitedSelf区分开，否则将无法添加具有相同前继节点的新邻居
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node node = queue.poll();

            for (String neighbor : word2Neighbors.get(node.val)) {

                if (visitedSelf.contains(neighbor)) continue; //避免与上一层已搜索过的word重复！(但本层添加的新邻居并不包含在这）

                Node cand = new Node(neighbor, node);
                if (visitedOp.contains(neighbor)) {
                    cands.add(cand);
                }

                queue.offer(cand);
                genNeighbors(dict, neighbor, word2Neighbors);
                newVisited.add(neighbor);
            }
        }

        visitedSelf.addAll(newVisited);
        return cands;
    }

    /**
     * Generate its neighbors for the word
     * @param dict
     * @param word
     * @param word2Neighbors
     * @return
     */
    private void genNeighbors(Set<String> dict, String word, Map<String, HashSet<String>> word2Neighbors) {
        if(word2Neighbors.containsKey(word)) return;

        HashSet<String> neighbors = new HashSet<>();
        word2Neighbors.put(word, neighbors);

        for (int i = 0; i < word.length(); i++) {
            String lPart = word.substring(0, i);
            String rPart = word.substring(i + 1);
            char replaced = word.charAt(i);

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == replaced) continue;

                String neighbor = lPart + c + rPart;
                if (!dict.contains(neighbor)) continue;

                word2Neighbors.get(word).add(neighbor);
            }
        }
    }

    private class Node {
        String val;
        Node pre;

        Node(String val) {
            this.val = val;
            pre = null;
        }

        Node(String val, Node pre) {
            this.val = val;
            this.pre = pre;
        }
    }
}
