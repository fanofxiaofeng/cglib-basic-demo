package com.demo.util

import net.sf.cglib.proxy.MethodInterceptor

class SimpleMethodInterceptor : MethodInterceptor {
    /**
     * @param obj    "this", the enhanced object (i.e. a child class instance)
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param proxy  used to invoke super (non-intercepted method); may be called
     * as many times as needed
     */
    @kotlin.Throws(Throwable::class)
    override fun intercept(
        obj: Any,
        method: java.lang.reflect.Method,
        args: Array<Any>,
        proxy: net.sf.cglib.proxy.MethodProxy
    ): Any {
        // "obj" is an instance of the child class,
        // proxy.invokeSuper(...) will finally invoke corresponding method in parent class (i.e. "IntegerAdded" class)
        val result = proxy.invokeSuper(obj, args)
        println("output from SimpleMethodInterceptor begins >>>")
        println("params: " + args.contentToString())
        println("result: $result")
        println("<<< output from SimpleMethodInterceptor ends")
        return result
    }
}