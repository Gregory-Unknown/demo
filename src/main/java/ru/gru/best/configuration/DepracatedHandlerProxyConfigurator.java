package ru.gru.best.configuration;

import net.sf.cglib.proxy.Enhancer;
import ru.gru.best.configuration.interfaces.ProxyConfigurator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DepracatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            if (implClass.getInterfaces().length == 0 || implClass.getMethods().length == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> getInvocationHandlerLogic(method, t));
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(method, t));
        } else {
            return t;
        }
    }

    private static Object getInvocationHandlerLogic(Method method, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA за что ?!");
        return method.invoke(t);
    }
}
