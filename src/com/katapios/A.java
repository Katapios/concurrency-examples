package com.katapios;

class A {

    synchronized void foo (B b){
        String name = Thread.currentThread().getName();
        System.out.println(name + " has entered into the method A.foo()");
        try {
        } catch (Exception e) {
            System.out.println("Class A has been interrupted");
        }
        System.out.println(name + " try to call B.last() method");
        b.last();
    }

    synchronized void last() {
        System.out.println("into the method A.last()");
    }
}
