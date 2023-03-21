package com.demo.util

import net.sf.cglib.proxy.FixedValue

class SimpleFixedValue(private val value: Int) : FixedValue {
    override fun loadObject(): Int {
        return value
    }
}