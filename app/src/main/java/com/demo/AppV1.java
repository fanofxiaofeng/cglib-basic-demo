package com.demo;

import com.demo.cg.IntegerAdder;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class AppV1 {

    public static void main(String[] args) {
        NoOp noOp = NoOp.INSTANCE;

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, noOp);

        int result = calculator.add(1, 2);
        System.out.println("result: " + result);
    }
}
