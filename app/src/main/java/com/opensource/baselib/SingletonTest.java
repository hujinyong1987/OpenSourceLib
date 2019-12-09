package com.opensource.baselib;
Holder

class SingletonTest {
    private static final SingletonTest ourInstance = new SingletonTest();

    static SingletonTest getInstance() {
        return ourInstance;
    }

    private SingletonTest() {
    }
}
