package org.example;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class PersonInvocationHandler implements InvocationHandler {
    private final Person person;
    public PersonInvocationHandler(Person person) {
        this.person = person;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Extra logic before
        System.out.println("[Proxy] Before calling method: " + method.getName());

        // Call the original method on the real object
        Object result = method.invoke(person, args);

        // Extra logic after
        System.out.println("[Proxy] After calling method: " + method.getName());
        return result;
    }
}