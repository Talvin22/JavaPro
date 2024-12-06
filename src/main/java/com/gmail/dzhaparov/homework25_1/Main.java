package com.gmail.dzhaparov.homework25_1;

public class Main {
    public void run() {
        // Створення фабрик
        TransportFactory carFactory = new CarFactory();
        TransportFactory planeFactory = new PlaneFactory();

        // Створення об'єктів
        Transport car = carFactory.createTransport();
        Transport plane = planeFactory.createTransport();

        // Виконання методів
        car.move();
        plane.move();
    }

    public static void main(String[] args) {
        Main client = new Main();
        client.run();
    }
}