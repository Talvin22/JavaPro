package com.gmail.dzhaparov.homework13_1;


import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final ReentrantLock lock = new ReentrantLock();

    public synchronized int modify(int num) {
        lock.lock();
        try {
            num = num * 3;
            return num;
        } finally {
            lock.unlock();
        }
    }
}
