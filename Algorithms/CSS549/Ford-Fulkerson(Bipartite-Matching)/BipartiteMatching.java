package com.yyf.css549.FordFulkerson;

import java.util.*;

/**
 * @author yifei yang
 */
public class BipartiteMatching {

    public static void main(String[] args) {

        // use hashmap to store matching pairs
        Map<Integer, Integer> pairs = new HashMap<>();

        // Read data from file into Graph G.
//        ParseInputFile pif = new ParseInputFile("src/com/yyf/css549/FordFulkerson/program3data.txt");
        ParseInputFile pif = new ParseInputFile("src/com/yyf/css549/FordFulkerson/3Phases.txt");
//        ParseInputFile pif = new ParseInputFile("src/com/yyf/css549/FordFulkerson/testinput.txt");
//        ParseInputFile pif = new ParseInputFile("src/com/yyf/css549/FordFulkerson/testinput3.txt");
//        ParseInputFile pif = new ParseInputFile("src/com/yyf/css549/FordFulkerson/testinput100.txt");
        Graph G = pif.getGraph();

        // Create residual graph Gf by adding source and sink nodes and edges from source and to sink.
        // Initialize flow f to zero along each edge.
        Graph GF = Graph.createResidualGraph(G);

        // While not done:
        while (true) {

            // 	Construct level graph LG from Gf using breadth-first search (delete back and cross edges).
            LevelGraph LG = LevelGraph.getLevelGraph(GF);

            // 	If no path exists from source to sink (i.e., sink not found during BFS), output matching, done.
            if (LG == null) {
                break;
            }

            // 	Initialize location to source node, path to empty.
            int location = 0;
            ArrayList<Edge> path = new ArrayList<>();

            // 	While not stuck at source:
            while (!LG.isStuckAt(0)) {

                // If location is sink:
                if (location == LG.getNodeCount() - 1) {

                    // Augment flow with path.
                    for (Edge edge : path) {

                        // update matching pair along augment path while startNode is on the left side
                        if (edge.getStartNode() > 0 && edge.getStartNode() < GF.getNodeCount() / 2) {
                            pairs.put(edge.getStartNode(), edge.getEndNode());
                        }

                        // Update Gf.
                        GF.updateReverseFlow(edge);

                        // Delete edges in path from LG.
                        LG.deleteEdge(edge);
                    }

                    // Set location to source.
                    location = 0;

                    // Clear path.
                    path.clear();
                } else {

                    //	if stuck, retreat:
                    if (LG.isStuckAt(location)) {

                        //	Delete current node and incoming edges from LG.
                        Edge edge = path.remove(path.size() - 1);

                        // reset entry node
                        location = edge.getStartNode();

                        //	Delete last edge from path.
                        LG.deleteEdge(edge);
                    } else {

                        for (int i = 0; i < LG.getNodeCount(); i++) {
                            //	Advance along some edge in LG that leaves current location.
                            if (LG.isConnected(location, i)) {
                                //	Update current path.
                                path.add(new Edge(location, i));
                                // update next entry node
                                location = i;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Formatted output by nodes' indexes
        formatOutput(GF.getNodeNames(), pairs);
    }

    public static void formatOutput(String[] nodeNames, Map<Integer, Integer> pairs) {
        List<Integer> keys = new ArrayList<>(pairs.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            System.out.println(nodeNames[key] + " / " + nodeNames[pairs.get(key)]);
        }
        System.out.format("%d total matches", pairs.size());
    }
}
