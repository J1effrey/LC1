package com.yyf.css549.FordFulkerson;

import java.util.*;

/**
 * @author yifei yang
 * Level Graph extends Graph it has some functions that only happens in level graph
 * like deleting edges and whether it stucked at some node
 */
public class LevelGraph extends Graph {

    public LevelGraph(String[] nodeNames, int[][] adjMatrix) {
        super(nodeNames, adjMatrix);
    }

    /**
     * determine whether levelGraph is stuck at somewhere which means no out edges
     * @param location index
     * @return boolean
     */
    public boolean isStuckAt(int location) {
        return Arrays.stream(this.getAdjMatrix()[location]).allMatch(x -> x == 0);
    }

    /**
     * determine whether two nodes have path
     * @param from Integer
     * @param to Integer
     * @return Boolean
     */
    public boolean isConnected(int from, int to) {
        return this.getAdjMatrix()[from][to] == 1;
    }

    /**
     * delete an existing edge from our LevelGraph
     * @param edge Edge
     */
    public void deleteEdge(Edge edge) {
        this.getAdjMatrix()[edge.getStartNode()][edge.getEndNode()] = 0;
    }

    /**
     * return a new LevelGraph from out residual graph based on BFS
     * @param residualGraph  residual graph
     * @return our new LevelGraph
     */
    public static LevelGraph getLevelGraph(Graph residualGraph) {
        // get the number of all nodes of residual graph
        int nodeCount = residualGraph.getNodeCount();

        // get adjacency matrix of residual graph
        int[][] adjMatrix = residualGraph.getAdjMatrix();

        // intialize adjacency matrix of level graph
        int[][] adjMatrixOfLG = new int[adjMatrix.length][adjMatrix.length];

        // initialize the end of out BFS
        boolean hasPathToSink = false;

        // use queue to implement BFS
        Queue<Integer> queue = new LinkedList<>();

        // visited used to mark if a node has been traversed during BFS
        boolean[] visited = new boolean[nodeCount];

        // record all layers that has been traverse before
        Set<Integer> prevLayers = new HashSet<>();

        queue.offer(0);
        visited[0] = true;
        prevLayers.add(0);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            // keep track of all nodes in out current layer
            Set<Integer> currLayer = new HashSet<>();
            while (qSize-- > 0) {
                int curr = queue.poll();
                for (int i = 0; i < nodeCount; i++) {
                    // if there exists a path which endNode is on its next layer
                    if (adjMatrix[curr][i] == 1 && !prevLayers.contains(i)) {
                        // it means we have found a path from source tp sink during our BFS
                        if (i == nodeCount - 1) {
                            hasPathToSink = true;
                        }
                        // add current edge to our level graph
                        adjMatrixOfLG[curr][i] = 1;

                        // is not visited, add this node into current layer and queue for next round of BFS
                        if (!visited[i]) {
                            visited[i] = true;
                            queue.add(i);
                            currLayer.add(i);
                        }
                    } else {
                        adjMatrixOfLG[curr][i] = 0;
                    }
                }
            }
            // after traversing current layer, save it to our previous layers for next BFS
            prevLayers.addAll(currLayer);
        }

        // return a new Level Graph if there exists a path from source to sink
        LevelGraph levelGraph = new LevelGraph(residualGraph.getNodeNames(), adjMatrixOfLG);
        return hasPathToSink ? levelGraph : null;
    }
}
