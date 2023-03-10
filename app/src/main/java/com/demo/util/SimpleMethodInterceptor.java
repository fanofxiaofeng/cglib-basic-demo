package com.demo.util;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleMethodInterceptor implements MethodInterceptor {
    /**
     * @param obj    "this", the enhanced object (i.e. a child class instance)
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param proxy  used to invoke super (non-intercepted method); may be called
     *               as many times as needed
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // "obj" is an instance of the child class,
        // proxy.invokeSuper(...) will finally invoke corresponding method in parent class (i.e. "IntegerCalculator" class)
        Object result = proxy.invokeSuper(obj, args);

        System.out.println("params: " + Arrays.toString(args));
        System.out.println("result: " + result);
        System.out.println();

        return result;
    }
}
