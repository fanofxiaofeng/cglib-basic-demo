package com.demo;

import com.demo.cg.IntegerAdder;
import com.demo.util.SimpleFixedValue;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class AppV1 {

    private static final int VALUE = 9876;

    public static void main(String[] args) {
        FixedValue fixedValue = new SimpleFixedValue(VALUE);

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, fixedValue);

        int result = calculator.add(1, 2);
        System.out.println("result: " + result);
    }
}
