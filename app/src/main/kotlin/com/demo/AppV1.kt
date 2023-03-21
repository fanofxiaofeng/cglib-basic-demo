package com.demo

import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.NoOp
import com.demo.cg.IntegerAdder

object AppV1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val noOp = NoOp.INSTANCE
        val calculator =
            Enhancer.create(IntegerAdder::class.java, noOp) as IntegerAdder
        val result = calculator.add(1, 2)
        println("result: $result")
    }
}