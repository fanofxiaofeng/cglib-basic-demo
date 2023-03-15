package com.demo;


import com.demo.cg.IntegerAdder;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class AppV2 {

    private static final String OUTPUT_DIR = "./generated/v2";

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, OUTPUT_DIR);
        NoOp noOp = NoOp.INSTANCE;

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, noOp);

        int result = calculator.add(1, 2);
        System.out.println("result: " + result);
    }
}
