package com.demo;

import com.demo.cg.IntegerAdder;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class AppV4 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./generated");
        NoOp noOp = NoOp.INSTANCE;

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, noOp);
        calculator.add(1, 2);
    }
}
