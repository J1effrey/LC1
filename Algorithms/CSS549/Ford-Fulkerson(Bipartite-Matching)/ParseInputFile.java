package com.yyf.css549.FordFulkerson;

import java.io.*;

/**
 * @author yifei yang
 */
public class ParseInputFile {

    /**
     * input fileName
     */
    private String fileName;

    /**
     * parsed graph
     */
    private Graph graph;

    /**
     * number of nodes
     */
    public int numberOfNodes;

    /**
     * number of edges
     */
    public int numberOfEdges;

    /**
     * get fileName that needs to be parsed
     * @param fileName input
     */
    public ParseInputFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * return graph from parsed input file
     * @return
     */
    public Graph getGraph() {
        this.parseFile();
        return graph;
    }

    /**
     * parse nodes' names and edges in the file and transform them into a graph;
     */
    public void parseFile() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(this.fileName);
            br = new BufferedReader(fr);
            this.numberOfNodes = Integer.parseInt(br.readLine().trim());
            String[] nodeNames = new String[this.numberOfNodes];
            for (int i = 0; i < this.numberOfNodes; i++) {
                nodeNames[i] = br.readLine().trim();
            }
            this.numberOfEdges = Integer.parseInt(br.readLine().trim());
            Edge[] edges = new Edge[this.numberOfEdges];
            for (int i = 0; i < this.numberOfEdges; i++) {
                String edge = br.readLine().trim();
                String[] nodes = edge.split(" ");
                edges[i] = new Edge(Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1]));
            }

            // get graph
            this.graph = new Graph(nodeNames, edges);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
