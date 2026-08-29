package com.sehyun.backend.java.gc;

public class CircularReferenceExample {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.b = b;
        b.a = a;

        a = null;
        b = null;

        // A와 B가 서로 참조하고 있더라도
        // GC Root에서 도달할 수 없으면 GC 대상이 될 수 있다.
    }

    static class A {
        B b;
    }

    static class B {
        A a;
    }
}