package com.demo;

import com.demo.cg.IntegerAdder;
import com.demo.util.SimpleFixedValue;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class AppV3 {

    private static final int VALUE = 9876;

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./generated");
        FixedValue fixedValue = new SimpleFixedValue(VALUE);

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, fixedValue);
        calculator.add(1, 2);
    }
}
