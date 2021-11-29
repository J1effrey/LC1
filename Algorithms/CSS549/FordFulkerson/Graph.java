package com.yyf.css549.FordFulkerson;

public class Graph {
    String[] nodeNames;
    int[][] adjMatrix;
    int nodeCount;
    public Graph(String[] nodeNames, Edge[] edges) {
        this.nodeNames = nodeNames;
        this.nodeCount = nodeNames.length;
        this.adjMatrix = new int[this.nodeCount][this.nodeCount];
        for (Edge edge : edges) {
            this.adjMatrix[edge.startNode - 1][edge.endNode - 1] = 1;
        }
    }

    public Graph(String[] nodeNames, int[][] adjMatrix) {
        this.nodeNames = nodeNames;
        this.nodeCount = nodeNames.length;
        this.adjMatrix = adjMatrix;
    }

    public int getNodeCount() {
        return this.nodeCount;
    }

    public String[] getNodeNames() {
        return this.nodeNames;
    }

    public int[][] getAdjMatrix() {
        return this.adjMatrix;
    }
}
