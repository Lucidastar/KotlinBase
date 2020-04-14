##### KotlinBase

##### [kotlin的基础语法学习](https://www.kotlincn.net/docs/reference/basic-syntax.html)

##### 变量声明

```kotlin
var name = "lucida"
var age:Int = 15
var name1 : String? = null
name = name1!!
```

##### var 表示一个变量

val 表示一个不可变的变量  

?代表一个可以为空  不加？是不能为空的

!!代表强转，表示name1不为空了

--------------------------------------------------------

##### 函数

函数的定义

```kotlin
//有返回值的函数定义
fun test(string: String) : String{
    println("结果:${string}")  //引用一个字符串，可以直接获取，然后进行拼接
    return string
}
//没有返回值的函数定义
fun test(string: String){
    return string
}
```

##### kotlin与java之间互相调用

object关键字，object后面跟一个类名，相当于匿名内部类

```kotlin
//匿名内部类的写法
object Test{
    fun say(string: String){
        println(string)
    }
}
```

```kotlin
fun checkClass(clazz: Class<TestDemo>){
    println("传入了一个java的class:"+clazz.name)
}

```

```java
public static void checkKtClass(Class<KUtilsKt> clazz){
    System.out.println("kotlin的class"+clazz.getName());
}
```

调用时

```java
//java中调用kotlin的class参数
JUtils.checkKtClass(KUtilsKt.class);
```

```kotlin
//kotlin中调用java的class参数
checkClass(TestDemo::class.java)
```

这就是他们之间的不同。

##### 函数与lambda闭包

嵌套函数(一般使用到递归)

```kotlin
fun function (): Unit {
    println("begin")
    fun say(count:Int = 10){
        println(count)
        if (count > 0){
            say(count - 1)
        }
    }
    say()
}
```

扩展函数

Lambda闭包语法

高阶函数

内联函数

