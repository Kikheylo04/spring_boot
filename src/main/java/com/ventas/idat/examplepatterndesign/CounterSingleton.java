package com.ventas.idat.examplepatterndesign;

public class CounterSingleton {
    private static CounterSingleton instance;
    private int count = 0;

    private CounterSingleton() {
    }

    public static CounterSingleton getInstance() {
        if (instance == null) {
            instance = new CounterSingleton();
        }
        return instance;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
