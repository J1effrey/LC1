package com.yyf.css549.FordFulkerson;

/**
 * @author yifei yang
 */
public class Graph {
    /**
     * nodeNames  nodes and their corresponding names
     */
    private String[] nodeNames;

    /**
     * adjMatrix  adjacency matrix
     */
    private int[][] adjMatrix;

    /**
     * nodeCount  the number of unique nodes
     */
    private int nodeCount;

    /**
     * use node names and node edges to construct our graph
     * constructor
     *
     * @param nodeNames String array
     * @param edges     (startNode, endNode)
     */
    public Graph(String[] nodeNames, Edge[] edges) {
        this.nodeNames = nodeNames;
        this.nodeCount = nodeNames.length;
        this.adjMatrix = new int[this.nodeCount][this.nodeCount];
        for (Edge edge : edges) {
            this.adjMatrix[edge.getStartNode() - 1][edge.getEndNode() - 1] = 1;
        }
    }

    /**
     * use node names and adjacency matrix to construct our graph
     *
     * @param nodeNames String array
     * @param adjMatrix adjacency matrix
     */
    public Graph(String[] nodeNames, int[][] adjMatrix) {
        this.nodeNames = nodeNames;
        this.nodeCount = nodeNames.length;
        this.adjMatrix = adjMatrix;
    }

    /**
     * @param edge
     */
    public void updateReverseFlow(Edge edge) {
        int startNode = edge.getStartNode();
        int endNode = edge.getEndNode();
        this.adjMatrix[startNode][endNode] = 0;
        this.adjMatrix[endNode][startNode] = 1;
    }

    /**
     * create residual graph from original graph by adding source and sink
     *
     * @param graph original graph from input file
     * @return residual graph
     */
    public static Graph createResidualGraph(Graph graph) {
        // input graph
        int originalGraphNodesCount = graph.getNodeCount();
        String[] nodesOfOriginalGraph = graph.getNodeNames();
        int[][] adjMatrixOfOriginalGraph = graph.getAdjMatrix();

        // residual graph
        int residualGraphNodesCount = originalGraphNodesCount + 2;
        String[] nodesOfResidualGraph = new String[residualGraphNodesCount];
        int[][] adjMatrixOfResidualGraph = new int[residualGraphNodesCount][residualGraphNodesCount];

        // add source and sink node to beginning and ending position
        String sourceNode = "Source";
        String sinkNode = "Sink";
        nodesOfResidualGraph[0] = sourceNode;
        nodesOfResidualGraph[residualGraphNodesCount - 1] = sinkNode;

        // copy names from graph G to residual Graph GF
        if (originalGraphNodesCount >= 0) {
            System.arraycopy(nodesOfOriginalGraph, 0, nodesOfResidualGraph, 1, originalGraphNodesCount);
        }

        // add edges from source to nodes on the left side
        for (int i = 1; i < residualGraphNodesCount / 2; i++) {
            adjMatrixOfResidualGraph[0][i] = 1;
        }

        // add edges from nodes on the right side to sink
        for (int i = residualGraphNodesCount / 2; i < residualGraphNodesCount - 1; i++) {
            adjMatrixOfResidualGraph[i][residualGraphNodesCount - 1] = 1;
        }

        // copy edges from graph G to residual Graph GF
        for (int i = 0; i < originalGraphNodesCount; i++) {
            System.arraycopy(adjMatrixOfOriginalGraph[i], 0, adjMatrixOfResidualGraph[i + 1], 1, originalGraphNodesCount);
        }

        return new Graph(nodesOfResidualGraph, adjMatrixOfResidualGraph);
    }

    /**
     * getter and setter
     */
    public int getNodeCount() {
        return this.nodeCount;
    }

    public String[] getNodeNames() {
        return this.nodeNames;
    }

    public int[][] getAdjMatrix() {
        return this.adjMatrix;
    }

    public void setNodeNames(String[] nodeNames) {
        this.nodeNames = nodeNames;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }
}
