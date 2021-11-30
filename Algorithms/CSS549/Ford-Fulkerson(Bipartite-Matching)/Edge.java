package com.yyf.css549.FordFulkerson;

/**
 * @author yifei yang
 * edge represents the flow from startNode to endNode
 */
public class Edge {
    private int startNode;
    private int endNode;

    public Edge(int startNode, int endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public int getStartNode() {
        return startNode;
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public void setEndNode(int endNode) {
        this.endNode = endNode;
    }
}
