package com.demo.util;

import net.sf.cglib.proxy.FixedValue;

public class SimpleFixedValue implements FixedValue {

    private final int value;

    public SimpleFixedValue(int value) {
        this.value = value;
    }

    @Override
    public Object loadObject() {
        return value;
    }
}
