package com.gmail.dzhaparov.homework20_1;

import java.util.*;

public class Graph {
    private Map<Integer, Set<Integer>> adjacencyList;


    public Graph() {
        adjacencyList = new HashMap<>();
    }


    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }


    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }


    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.get(vertex).forEach(neighbor -> adjacencyList.get(neighbor).remove(vertex));
            adjacencyList.remove(vertex);
        }
    }


    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            adjacencyList.get(source).remove(destination);
            adjacencyList.get(destination).remove(source);
        }
    }


    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }


    public boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }


    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println("Вершина " + entry.getKey() + " поєднана з " + entry.getValue());
        }
    }
}