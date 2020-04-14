##### KotlinBase
kotlin的基础语法学习

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