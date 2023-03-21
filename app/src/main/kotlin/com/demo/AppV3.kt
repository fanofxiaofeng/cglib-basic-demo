package com.demo

import com.demo.cg.IntegerAdder
import com.demo.util.SimpleFixedValue
import net.sf.cglib.core.DebuggingClassWriter
import net.sf.cglib.proxy.Enhancer

object AppV3 {

    private const val FIXED_VALUE = 42

    private const val OUTPUT_DIR = "./generated/v3"

    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, OUTPUT_DIR)
        val fixedValue = SimpleFixedValue(FIXED_VALUE)
        val calculator =
            Enhancer.create(IntegerAdder::class.java, fixedValue) as IntegerAdder
        val result = calculator.add(1, 2)
        println("result: $result")
    }
}