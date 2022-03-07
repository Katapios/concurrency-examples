package com.katapios;

class B {

    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " has entered into the method B.bar()");
        try {
        } catch(Exception e) {
            System.out.println("Class B has been interrupted");
        }
        System.out.println(name + " try to call A.last() method");
        a.last();
    }

    synchronized void last(){
        System.out.println("into the method A.last()");
    }
}
