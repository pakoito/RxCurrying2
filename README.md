#RxCurrying2

RxCurrying2 is a library to allow [currying](https://en.wikipedia.org/wiki/Currying) on RxJava 2.X function primitives.

For the RxJava 1.X version please go to [RxCurrying](https://github.com/pakoito/RxCurrying).

##Usage

RxCurrying contains two classes, `RxCurryingConsumer` and `RxCurryingFunction`. Each contains a set of `curry()` methods to do split any function into its curried version. Curried methods allows calling them one parameter at a time, and execute them at the end. For example, a `Func3<A, B, C, R>` becomes a `Function<A, Function<B, Function<C, R>>>`, or an `Consumer4<A, B, C, D>` becomes `Function<A, Function<B, Function<C, Consumer<D>>>`.

Function to print the sum of two numbers:
```java
Function<Integer, Consumer<Integer>> adder = RxCurryingConsumer.curry((int first, int second) -> { System.out.print(first + second); });
Consumer<Integer> intermediate = adder.call(3);
intermediate.call(2);  // prints 5
```

Append 5 strings:
```java
Function<String, Function<String, Function<String, Function<String, Function<String, String>>>>> appender = RxCurryingFunction.curry((String first, String second, String third, String fourth, String fifth) -> { return first + second + third + fourth + fifth; );
Function<String, String> intermediate = appender.call("Hello ").call("This ").call("Is ").call("Curried ");
String value = last.call("Func"); // value == "Hello This is Curried Func"
```

##Distribution

Add as a dependency to your `build.gradle`
```groovy
repositories {
    ...
    maven { url "https://jitpack.io" }
    ...
}

dependencies {
    ...
    compile 'com.github.pakoito:RxCurrying2:1.0.0'
    ...
}
```
or to your `pom.xml`
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.pakoito</groupId>
    <artifactId>RxCurrying2</artifactId>
    <version>1.0.0</version>
</dependency>
```
##License

Copyright (c) pakoito 2017

The Apache Software License, Version 2.0

See LICENSE.md
