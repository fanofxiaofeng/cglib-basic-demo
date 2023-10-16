package com.demo

import com.demo.cg.IntegerAdder
import com.demo.util.SimpleMethodInterceptor
import net.sf.cglib.core.DebuggingClassWriter
import net.sf.cglib.proxy.Enhancer

object AppV4 {

    private const val OUTPUT_DIR = "./generated/v4"

    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, OUTPUT_DIR)
        val methodInterceptor = SimpleMethodInterceptor()
        val calculator =
            Enhancer.create(IntegerAdder::class.java, methodInterceptor) as IntegerAdder
        val result = calculator.add(1, 2)
        println("result: $result")
    }
}