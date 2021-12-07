# JDK 8

## 一、 lambda表达式

### 1. 需求分析

### 2. 初体验

### 3. Lambda表达式语法规则

### 4. @FunctionalInterface注解

### 5. Lambda表达式原理

### 6. Lambda表达式省略写法

### 7. Lambda表达式使用前提

### 8. Lambda和匿名内部类对比

## 二、 接口中新增方法

### 1. jdk8中接口的新增

### 2. 默认方法

### 3. 静态方法

### 4. 区别

## 三、 函数式接口

### 1. 由来

### 2. 介绍

#### 2.1 Supplier

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}

```



#### 2.2 Consumer

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```



#### 2.3 Function

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```



#### 2.4 Predicate

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```



## 四、 方法引用

## 五、 Stream API

## 六、 新时间API

## 七、 替他特性

