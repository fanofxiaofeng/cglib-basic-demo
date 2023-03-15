package com.demo;

import com.demo.cg.IntegerAdder;
import com.demo.util.SimpleMethodInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class AppV4 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./generated");
        MethodInterceptor interceptor = new SimpleMethodInterceptor();

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, interceptor);
        calculator.add(1, 2);
    }
}
