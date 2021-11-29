package com.yyf.css549.FordFulkerson;

import java.io.*;
import java.util.ArrayList;


public class ParseInputFile {
    private String fileName;
    private Graph graph;
    public int numberOfNodes;
    public int numberOfEdges;


    public ParseInputFile(String fileName) {
        this.fileName = fileName;
    }

    public Graph getGraph() {
        this.parseFile();
        return graph;
    }

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
