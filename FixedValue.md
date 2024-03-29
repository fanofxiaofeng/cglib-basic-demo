# cglib-basic-demo

Previous page: [NoOp.md](NoOp.md)

## Step 4: Create a class that implements `FixedValue` interface

To make the code easier to understand,
I will create a specific `class`, 
i.e. `SimpleFixedValue` that implements `FixedValue` interface.

Its main logic is as follows

```kotlin
class SimpleFixedValue(private val value: Int) : FixedValue {
    override fun loadObject(): Int {
        return value
    }
}
```

Its full code is in [SimpleFixedValue.kt](app/src/main/kotlin/com/demo/util/SimpleFixedValue.kt)


## Step 5: Use `Enhancer` to generate a child class for `IntegerAdder`

Now we can use `Enhancer` in `cglib` to create a child `class` for `IntegerAdder`.

```kotlin
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
```


Its complete code for is in
[AppV3.kt](app/src/main/kotlin/com/demo/AppV3.kt)

Let's execute the following command to run the `main` method in `AppV3`.

```bash
gradle -PmainClass=com.demo.AppV3 :app:run
```

The result is as follows.
![result.png](pic/v3/result.png)

The child class will be saved into a local file.

![child.png](pic/v3/child.png)


With the help of [IntelliJ IDEA](https://www.jetbrains.com/idea/),
we can see the decompiled result as follows.
```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.demo.cg;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.FixedValue;

public class IntegerAdder$$EnhancerByCGLIB$$eefed20f extends IntegerAdder implements Factory {
    private boolean CGLIB$BOUND;
    public static Object CGLIB$FACTORY_DATA;
    private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
    private static final Callback[] CGLIB$STATIC_CALLBACKS;
    private FixedValue CGLIB$CALLBACK_0;
    private static Object CGLIB$CALLBACK_FILTER;

    static void CGLIB$STATICHOOK1() {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
    }

    public final int add(int var1, int var2) {
        FixedValue var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        Object var3 = var10000.loadObject();
        return var3 == null ? 0 : ((Number)var3).intValue();
    }

    public final boolean equals(Object var1) {
        FixedValue var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        Object var2 = var10000.loadObject();
        return var2 == null ? false : (Boolean)var2;
    }

    public final String toString() {
        FixedValue var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        return (String)var10000.loadObject();
    }

    public final int hashCode() {
        FixedValue var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        Object var1 = var10000.loadObject();
        return var1 == null ? 0 : ((Number)var1).intValue();
    }

    protected final Object clone() throws CloneNotSupportedException {
        FixedValue var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        return var10000.loadObject();
    }

    public IntegerAdder$$EnhancerByCGLIB$$eefed20f() {
        CGLIB$BIND_CALLBACKS(this);
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] var0) {
        CGLIB$THREAD_CALLBACKS.set(var0);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] var0) {
        CGLIB$STATIC_CALLBACKS = var0;
    }

    private static final void CGLIB$BIND_CALLBACKS(Object var0) {
        IntegerAdder$$EnhancerByCGLIB$$eefed20f var1 = (IntegerAdder$$EnhancerByCGLIB$$eefed20f)var0;
        if (!var1.CGLIB$BOUND) {
            var1.CGLIB$BOUND = true;
            Object var10000 = CGLIB$THREAD_CALLBACKS.get();
            if (var10000 == null) {
                var10000 = CGLIB$STATIC_CALLBACKS;
                if (var10000 == null) {
                    return;
                }
            }

            var1.CGLIB$CALLBACK_0 = (FixedValue)((Callback[])var10000)[0];
        }

    }

    public Object newInstance(Callback[] var1) {
        CGLIB$SET_THREAD_CALLBACKS(var1);
        IntegerAdder$$EnhancerByCGLIB$$eefed20f var10000 = new IntegerAdder$$EnhancerByCGLIB$$eefed20f();
        CGLIB$SET_THREAD_CALLBACKS((Callback[])null);
        return var10000;
    }

    public Object newInstance(Callback var1) {
        CGLIB$SET_THREAD_CALLBACKS(new Callback[]{var1});
        IntegerAdder$$EnhancerByCGLIB$$eefed20f var10000 = new IntegerAdder$$EnhancerByCGLIB$$eefed20f();
        CGLIB$SET_THREAD_CALLBACKS((Callback[])null);
        return var10000;
    }

    public Object newInstance(Class[] var1, Object[] var2, Callback[] var3) {
        CGLIB$SET_THREAD_CALLBACKS(var3);
        IntegerAdder$$EnhancerByCGLIB$$eefed20f var10000 = new IntegerAdder$$EnhancerByCGLIB$$eefed20f;
        switch (var1.length) {
            case 0:
                var10000.<init>();
                CGLIB$SET_THREAD_CALLBACKS((Callback[])null);
                return var10000;
            default:
                throw new IllegalArgumentException("Constructor not found");
        }
    }

    public Callback getCallback(int var1) {
        CGLIB$BIND_CALLBACKS(this);
        FixedValue var10000;
        switch (var1) {
            case 0:
                var10000 = this.CGLIB$CALLBACK_0;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    public void setCallback(int var1, Callback var2) {
        switch (var1) {
            case 0:
                this.CGLIB$CALLBACK_0 = (FixedValue)var2;
            default:
        }
    }

    public Callback[] getCallbacks() {
        CGLIB$BIND_CALLBACKS(this);
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    public void setCallbacks(Callback[] var1) {
        this.CGLIB$CALLBACK_0 = (FixedValue)var1[0];
    }

    static {
        CGLIB$STATICHOOK1();
    }
}

```

Let's take a closer look at the `add` method.
```java
public final int add(int var1, int var2) {
    FixedValue var10000 = this.CGLIB$CALLBACK_0;
    if (var10000 == null) {
        CGLIB$BIND_CALLBACKS(this);
        var10000 = this.CGLIB$CALLBACK_0;
    }

    Object var3 = var10000.loadObject();
    return var3 == null ? 0 : ((Number)var3).intValue();
}
```

So what is `this.CGLIB$CALLBACK_0`?
Maybe we can add a breakpoint to see what it is.
I will add a breakpoint as follows.
![breakpoint.png](pic/v3/breakpoint.png)

Let's run the `main` method in `AppV3` and pause at the above breakpoint.
![value.png](pic/v3/value.png)
We can see that the `CGLIB$CALLBACK_0` field is filled with an instance of type `SimpleFixedValue`,
and this instance seems to be exactly the same with `fixedValue` object inside [AppV3.kt](app/src/main/kotlin/com/demo/AppV3.kt) (in line 17).

OK, let's go back to the `add` method (I added some comment below)
```java
public final int add(int var1, int var2) {
    // as we observed previously,
    // when `add` method is called,
    // `this.CGLIB$CALLBACK_0` is an instance of type `SimpleFixedValue` 
    FixedValue var10000 = this.CGLIB$CALLBACK_0;
    if (var10000 == null) {
        CGLIB$BIND_CALLBACKS(this);
        var10000 = this.CGLIB$CALLBACK_0;
    }
    
    // so var10000.loadObject() should return 42 (and it will be converted to an `Integer`)
    Object var3 = var10000.loadObject();
    // the return value will be 42
    return var3 == null ? 0 : ((Number)var3).intValue();
}
```

Let's take a look at some other method, say `hashCode` method.
```java
public final int hashCode() {
    FixedValue var10000 = this.CGLIB$CALLBACK_0;
    if (var10000 == null) {
        CGLIB$BIND_CALLBACKS(this);
        var10000 = this.CGLIB$CALLBACK_0;
    }

    Object var1 = var10000.loadObject();
    return var1 == null ? 0 : ((Number)var1).intValue();
}
```
Do you think its code looks exactly the same with that of the `add` method?
I think so.

So if you add something like `println(calculator.hasCode())`
into [AppV3.kt](app/src/main/kotlin/com/demo/AppV3.kt), you will get `42`, too.

Since the `hashCode` method return `int` and `SimpleFixedValue` always provide Integer `42`, 
so nothing will go wrong (i.e. the type is consistent).

But what about the `toString` method?
```java
public final String toString() {
    FixedValue var10000 = this.CGLIB$CALLBACK_0;
    if (var10000 == null) {
        CGLIB$BIND_CALLBACKS(this);
        var10000 = this.CGLIB$CALLBACK_0;
    }

    return (String)var10000.loadObject();
}
```
Since `var10000.loadObject()` returns `42` (its type is `Integer` instead of `int`),
and `Integer` cannot be converted to a `String`,
so a `java.lang.ClassCastException` will be thrown if you add
`println(calculator.toString())` to [AppV3.kt](app/src/main/kotlin/com/demo/AppV3.kt)


OK, so `FixedValue` seems to be a little boring,
let's continue with [MethodInterceptor.md](MethodInterceptor.md).