package com.yyf.css549.FordFulkerson;

import java.util.Arrays;

public class BipartiteMatching {
    public static void main(String[] args) {
        /**
         * Read data from file into Graph G.
         * Create residual graph Gf by adding source and sink nodes and edges from source and to sink.
         * Initialize flow f to zero along each edge.
         * While not done:
         * 	Construct level graph LG from Gf using breadth-first search (delete back and cross edges).
         * 	If no path exists from source to sink (i.e., sink not found during BFS), output matching, done.
         * 	Initialize location to source node, path to empty.
         * 	While not stuck at source:
         * 		If location is sink:
         * 			Augment flow with path.
         * 			Update Gf.
         * 			Delete edges in path from LG.
         * 			Set location to source.
         * 			Clear path.
         * 		Else:
         * 			If stuck, retreat:
         * 				Delete current node and incoming edges from LG.
         * 				Delete last edge from path.
         * 			Else:
         * 				Advance along some edge in LG that leaves current location.
         * 				Update current path.
         */
        ParseInputFile pif = new ParseInputFile("src/program3data.txt");
        Graph graph = pif.getGraph();
        Graph residualGraph = createResidualGraph(graph);
        boolean isDone = false;
        while (!isDone) {
            
        }
    }

    public static Graph createResidualGraph(Graph graph) {
        int originalGraphNodesCount = graph.getNodeCount();
        String[] nodesOfOriginalGraph = graph.getNodeNames();
        int[][] adjMatrixOfOriginalGraph = graph.getAdjMatrix();

        int residualGraphNodesCount = originalGraphNodesCount + 2;
        String[] nodesOfResidualGraph = new String[residualGraphNodesCount];
        int[][] adjMatrixOfResidualGraph = new int[residualGraphNodesCount][residualGraphNodesCount];

        String sourceNode = "Source";
        String sinkNode = "Sink";
        nodesOfResidualGraph[0] = sourceNode;
        nodesOfResidualGraph[residualGraphNodesCount - 1] = sinkNode;
        if (originalGraphNodesCount >= 0)
            System.arraycopy(nodesOfOriginalGraph, 0, nodesOfResidualGraph, 1, originalGraphNodesCount);
//        System.out.println(Arrays.toString(nodesOfOriginalGraph));
//        System.out.println(Arrays.toString(nodesOfResidualGraph));

        for (int i = 1; i < residualGraphNodesCount / 2; i++) {
            adjMatrixOfResidualGraph[0][i] = 1;
        }
        for (int i = residualGraphNodesCount / 2; i < residualGraphNodesCount - 1; i++) {
            adjMatrixOfResidualGraph[i][residualGraphNodesCount - 1] = 1;
        }

        for (int i = 0; i < originalGraphNodesCount; i++) {
            System.arraycopy(adjMatrixOfOriginalGraph[i], 0, adjMatrixOfResidualGraph[i + 1], 1, originalGraphNodesCount);
        }

//        for (int i = 0; i <residualGraphNodesCount; i++) {
//            System.out.println(Arrays.toString(adjMatrixOfResidualGraph[i]));
//        }
        return new Graph(nodesOfResidualGraph, adjMatrixOfResidualGraph);
    }

}
