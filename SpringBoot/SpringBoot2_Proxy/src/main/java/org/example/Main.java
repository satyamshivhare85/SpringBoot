package org.example;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // Original object
        Man mohan = new Man("Mohan", 30, "Delhi", "India");

        // ClassLoader
        ClassLoader mohanClassLoader = mohan.getClass().getClassLoader();

        // Interfaces
        Class[] interfaces = mohan.getClass().getInterfaces();

        // Proxy-->consists
        Person proxymohan = (Person) Proxy.newProxyInstance(
                mohanClassLoader,
                interfaces,
                new PersonInvocationHandler(mohan)
        );

        // Method calls via proxy
        proxymohan.introduce(mohan.getName());
        proxymohan.sayAge(30);
        proxymohan.sayWhereFrom("Delhi", "India");
    }
}