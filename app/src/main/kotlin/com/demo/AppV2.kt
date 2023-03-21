package com.demo

import com.demo.cg.IntegerAdder
import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.NoOp
import net.sf.cglib.core.DebuggingClassWriter

object AppV2 {
    private const val OUTPUT_DIR = "./generated/v2"

    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, OUTPUT_DIR)
        val noOp = NoOp.INSTANCE
        val calculator =
            Enhancer.create(IntegerAdder::class.java, noOp) as IntegerAdder
        val result = calculator.add(1, 2)
        println("result: $result")
    }
}