package com.demo.util

class SimpleFixedValue(private val value: Int) : net.sf.cglib.proxy.FixedValue {
    override fun loadObject(): Any {
        return value
    }
}