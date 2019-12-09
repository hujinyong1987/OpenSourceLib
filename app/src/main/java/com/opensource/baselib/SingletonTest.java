package com.opensource.baselib;

class SingletonTest {
    private static final SingletonTest ourInstance = new SingletonTest();

    static SingletonTest getInstance() {
        return ourInstance;
    }



    static int a;
    private SingletonTest() {



    }
}
