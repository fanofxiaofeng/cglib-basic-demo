package com.demo;


import com.demo.cg.IntegerCalculator;
import com.demo.util.SimpleMethodInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class AppV2 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./generated");
        MethodInterceptor interceptor = new SimpleMethodInterceptor();

        IntegerCalculator calculator =
                (IntegerCalculator) Enhancer.create(IntegerCalculator.class, interceptor);
        calculator.add(1, 2);
        calculator.minus(1, 2);
    }
}
