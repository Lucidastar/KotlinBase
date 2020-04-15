##### KotlinBase

##### [kotlin的基础语法学习](https://www.kotlincn.net/docs/reference/basic-syntax.html)

#### 变量声明

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

#### 函数

###### 函数的定义

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

#### 函数与lambda闭包

##### 嵌套函数(一般使用到递归)

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

##### 扩展函数

我们定义一个Utils.kt，比如我们要扩展File中的方法，如下进行写

```kotlin
fun File.readText(charset: Charset = Charsets.UTF_8) :String = readBytes().toString(charset)
```

然后进行调用如下：

```kotlin
//这是在kotlin中进行调用
var file = File("local.properties")
println(file.readText(Charsets.UTF_8))
//就会打印出"local.properties"中的内容
```

```java
//这是在java中进行调用
File file = new File("local.properties");
String content = UtilsKt.readText(file, Charsets.UTF_8);
System.out.println(content);
```

因为扩展的是File中的方法，还可以这样写

```java
 File file = new File("local.properties");
 String temp = FilesKt.readText(file, Charsets.UTF_8);
 System.out.println(temp);
```

###### kotlin的扩展函数，会编译成静态的方法



##### Lambda闭包语法

java1.8的写法

```java
private void testThread(){
    Thread thread = new Thread(()->{
            
    });
    thread.start();
}
```

kotlin的写法

```kotlin
val thread = Thread(){

}
val thread2 = Thread{

}
val thread3 = Thread {
    -> Unit
}
```

Lambda闭包声明

大括号进行括起来

```kotlin
val echo = {string : String -> println(string)}
//箭头后边的是闭包体，前面是参数，后边是执行
val echoSub = {string : String ->
    println(string.subSequence(IntRange(0,2)))}
```

使用

```kotlin
echoSub("hello word")
```

Lambda的参数最多是22个

这时候如果进行扩展的话，会出现错误，可以创建一个java文件，来创建大于22参数的接口



##### 高阶函数

理解：函数（Lambda）的参数是函数（Lambda）

Lambda函数的声明

```kotlin
//Lambda函数的声明
fun lambdaStatement(isShowName: Boolean,block:() ->String){
    if (isShowName){
        println(block.toString())
    }
}
```

调用函数的声明

```kotlin
lambdaStatement(true){
    String.format("我的年龄是%d岁",12)
}
//当是一个函数时，并且是最后一个，我们就可以把参数写到小括号外边，如上：
lambdaStatement(true,{String.format("我的年龄是%d岁",12)})
```

inline一般会修饰高阶函数，因为会增加编译器的编译难度，所以不会随意的使用它

```kotlin
//inline的使用
inline fun lambdaStatement(isShowName: Boolean,block:() ->String){
    if (isShowName){
        println(block())
    }
}
```

##### 内联函数

在函数中再声明函数，然后进行调用，如：

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

#### 类与对象

声明

```kotlin
class MainActivity : AppCompatActivity() 
```

Kotlin的类默认是public final的

```kotlin
//添加open，表示不final
open class MainActivity : AppCompatActivity()
```

##### 构造函数

```kotlin
class MainActivity(var int : Int) : AppCompatActivity()
```

在构造函数中执行一些方法需要添加一个init的代码块

```kotlin
class MainActivity(var int : Int) : AppCompatActivity() {
	//初始化
    init {
        int = 12
        println("执行构造函数的初始化的工作")
    }
}
```

###### 多个构造函数

```kotlin
class CustomView: View {
    constructor(context: Context) : super(context)
    constructor(context: Context,attrs:AttributeSet):this(context,attrs,0)
    constructor(context: Context,attrs: AttributeSet,defStyleInt: Int):super(context,attrs,defStyleInt)

}
```

###### 访问修饰符

private protected public  internal(一个模块中的类都可以访问到，相当于一个module)

伴生对象

伴生对象一定要写到一个类的内部

```kotlin
class StringUtils {
    companion object {
        fun isEmpty(string: String) : Boolean{
            return "" == string
        }
    }
}
```

伴生对象的调用（kotlin中调用）

```kotlin
fun main(args: Array<String>) {
    StringUtils.isEmpty("hello")
}
//就像java中调用静态方法一样
```

伴生对象的调用（java中调用）

```java
public static void main(String[] args) {
    StringUtils.Companion.isEmpty("");
}
```

##### 单例类

通过伴生对象创建一个单例（比较推荐的一种单例写法）

```kotlin
class Single private constructor(){
    companion object{
        fun get():Single{
            return Holder.instance
        }
    }
    private object Holder{
        val instance = Single()
    }
}
```

##### 动态代理

###### java中的动态代理

第一步，创建一个接口

```java
public interface Subject {
    void say(String name);
}
```

第二步，实现这个接口

```java
public class SubjectImp implements Subject {
    @Override
    public void say(String name) {
        System.out.println("hello:"+name);
    }
}
```

第三步，创建代理，实现InvocationHandler接口

```java
public class SubjectProxy implements InvocationHandler {
    private Subject mSubject;
    public SubjectProxy(Subject mSubject) {
        this.mSubject = mSubject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------begin-------------");
        if (method.getName() == "say"){
            System.out.println("我执行了");
        }
        Object invoke = method.invoke(mSubject, args);//执行代理中被代理的对象的方法，也就是那个say方法，这样在不改变业务的情况下，增加一些其他操作，比如增加日志的拦截
        System.out.println("--------------end-------------");
        return invoke;
    }
}
```

第四步，进行调用

```java
Subject subjectImp = new SubjectImp();
Subject subjectProxy = (Subject) Proxy.newProxyInstance(subjectImp.getClass().getClassLoader(),subjectImp.getClass().getInterfaces(),new SubjectProxy(subjectImp));
subjectProxy.say("hello");
```

输出结果
>--------------begin-------------
我执行了
hello:hello
--------------end-------------

###### kotlin中的动态代理

```kotlin
interface Animal {
    fun bark()
}

class Dag : Animal{
    override fun bark() {
        println("wwww")
    }
}

class Zoo(animal: Animal):Animal by animal{
    override fun bark() {
        println("zoo")
    }
}
```

通过一个by关键字就可以进行代理了，他会生成静态方法，比java的运行要快好多。

调用：

```kotlin
//代理的调用
Zoo(Dag()).bark()
```

#### Kotlin特有的类

##### 数据类

```kotlin
data class User(var name:String,var age:Int)
```

自动生成get set方法，他是final类型的，不能被继承



##### 枚举类

```kotlin
enum class Command{
    A,B
}
fun getType(command: Command){
    when(command){
        Command.A -> println("a")
        Command.B -> println("b")
    }
}
```



##### 密闭类

```kotlin
sealed class SuperCommand{
    object A : SuperCommand()
    object B : SuperCommand()
    object C : SuperCommand()
    //密闭类可以扩展
    class E(var name :String): SuperCommand()
}
fun getSealed(superCommand: SuperCommand){
    when(superCommand){
        SuperCommand.A -> println("A")
        SuperCommand.B -> println("B")
        SuperCommand.C -> println("C")
        //通过构造可以传递参数
        SuperCommand.E("hello") -> println("E")
    }
}
```

密闭类是可以有子类的，需要写在同一个文件中，写到内部

密闭类可以扩展他的子类

一般会用密闭类来代替枚举类

#### 高级特性

##### 解构

##### 循环与集合操作符

##### 运算符重载

##### 作用域函数

##### 中辍表达式

##### DSL