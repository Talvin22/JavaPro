package com.gmail.dzhaparov.homework20_1;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph();


        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);


        System.out.println("Граф після додавання вершин и ребер:");
        graph.printGraph();


        System.out.println("\nЧи існує вершина 2? " + graph.hasVertex(2));
        System.out.println("Чи існує ребро між 1 и 3? " + graph.hasEdge(1, 3));


        graph.removeEdge(1, 2);
        System.out.println("\nГраф після виделення ребра між 1 и 2:");
        graph.printGraph();


    }
}
