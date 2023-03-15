# cglib-basic-demo

## Step 1: Write some code for `IntegerAdder`

Let's write code for `IntegerAdder`.
This `class` can calculate the sum of two integer parameters.

```java
public class IntegerAdder {
    public int add(int a, int b) {
        return a + b;
    }
}
```

Its complete code is in
[IntegerCalculator.java](app/src/main/java/com/demo/cg/IntegerAdder.java)


## Step 2: Use `Enhancer` and `NoOp` to generate a child class for `IntegerAdder`

Now we can use `Enhancer` and `NoOp` in `cglib` to create a child `class` for `IntegerAdder`.

```java
public class AppV1 {
    public static void main(String[] args) {
        NoOp noOp = NoOp.INSTANCE;

        IntegerAdder calculator =
                (IntegerAdder) Enhancer.create(IntegerAdder.class, noOp);

        int result = calculator.add(1, 2);
        System.out.println("result: " + result);
    }
}
```

Its complete code for is in
[AppV1.java](app/src/main/java/com/demo/AppV1.java)

Then we can run `main` method in `AppV1` with the following command
```bash
gradle -PmainClass=com.demo.AppV1 :app:run
```

The result is as follows
![result](pic/v1/result.png)


