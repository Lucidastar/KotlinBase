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
伴生对象一般在类构造之前已经被实例化

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

定义一下

```kotlin
class User(var name:String,var age:Int) {
    operator fun component1() = name//代表第一个元素
    operator fun component2() = age//代表第二个元素
}
//必须是这样的定义
```

>operator:将一个函数标记为重载一个操作符或者实现一个约定

使用

```kotlin
fun testJG(){
    val user = User("hyli",12)
    val (age,name) = user
    println(age)
    println(name)
}
```

比如map就使用了这种解构

```kotlin
fun testMap(){
    val map = mapOf<String,String>("key" to "key","value" to "value")
    for ((k,v) in map){
        println(k+"---"+v)
    }
}
```

##### 循环与集合操作符

```kotlin
fun testLoop(): Unit {
    for ( i in 1..10){
        println(i)
    }
    for (i in 1 until 10){
    }
    for (i in 10 downTo 2){
    }
    for (i in 1..20 step 2){

    }
    repeat(10){
        println(it)
    }

    //这种就是解构的方式
    val list = arrayListOf<String>("a","b","c","d")
    for ((index,name) in list.withIndex()){
        println("第${index}元素是：${name}")
    }
}
```

##### 运算符重载

与rxjava很像

```kotlin
fun testOperator(): Unit {
    val list = arrayListOf<Char>('a','b','c','d','e')
    val result = list
        .run { showResult(toList())}
        .map {it - 'a' }
        .filter { it > 0 }
        .find { it > 1 }
    println(result)
}

fun showResult(chars:List<Char>): List<Char> {
    for (char in chars){
        println("${char} == " + char.toInt())
    }
    return chars
}
```

##### 作用域函数

作用域可以操作一切，而集合的函数只能操作集合

```kotlin
//作用域操作符
fun testScopeOperator(): Unit {
    val user = User("hyli",12)
    //run和let都会返回闭包的执行结果，区别let有闭包参数，run没有闭包参数
    val runResult = user.run {
        this::class
    }
    println(runResult)
    val LetResut = user.let { user ->
        user::class
    }
    println(LetResut.toString())
    //also和apply都不返回执行结果，also有闭包参数，apply没有闭包参数
    user.also {
        user -> user.name = "also"
    }
    println(user.name)
    user.apply { this.name = "apply" }
    println(user.name)
    //takeIf的闭包返回一个判断结果，为false时，takeIf函数会返回空
    //takeUnless与takeIf相反 闭包的判断结果，为true时返回结果为空
    user.takeIf { user.name == "" }?.also { print(user.name) }
    user.takeUnless { user -> user.name == "" }
}
```

run{}

let{}

also{}

apply{} 

takeIf{}

takeUnless{}

##### 中辍表达式

定义

infix

像：step、 in 、zip  

##### 特殊符号

反引号：可以用反引号解决关键字冲突问题

```kotlin
fun `1234`() {
    println("test")
}
fun ` `(){
    
}
fun ``() = Unit
```

###### kotlin中如何进行比较对象

>kotlin                 java

a == b               a.equals(b)

a === b              a==b

```kotlin
public typealias A = File
val file = A("")
//typealias映射过来  像HasMap等等  跨平台兼容性
```

##### DSL（Domain Specific Language） 领域专用语言

内部DSL vs 外部DSL

内部是不依赖外部语言 像：JSON  XML CSS Makefile

外部需要依赖其他语言 像：Anko Kolley  buid.gradle

>优点：提高开发效率  减小沟通成本

​			

#### 语法特性

##### 变量、常量与只读

var与val声明的变量，最本质的区别是：val不能有setter

val是不能再复制的，可以重新他的get方法，达到set的目的

变量的声明

```kotlin
const val a = 12
object C{
    const val s = 0
}
class E{
    companion object{
        const val f = 0
    }
}
```

>const 只能修饰object的属性，或top-level变量
>
>const 变量的值必须在编译期间确定下来，所以他的类型只能是String或者基本类型

##### 空安全是如何实现的

##### 内联的特殊情况

>1. 在Kotlin中，内部Lambda是不允许中断外部函数执行的
>2. inline的Lambda可以中断外部函数调用
>3. crossinline不允许inline的Lambda中断外部函数执行
>4. noinline拒绝内联

###### 对2的事例

```kotlin
inline fun test(l:() ->Unit){
    l.invoke()
    return
}
```

```kotlin
fun main(args: Array<String>) {
    test {
        println("test")
        return
    }
    println("test")
}
```

当return后，就不会打印下边的test了，也就中断了外部的函数。

当去掉inline后，是不允许return的会报错。

###### 对于3的事例

我们只想中断内部，而会继续执行下边的函数，我们需要这样做

```kotlin
inline fun test(crossinline l:() ->Unit){
    l.invoke()
    return
}
```

```kotlin
test {
    println("test")
    return@test
    println("test1")
}
println("test3")
```

这时候，调用的时候，test1就不会打印，而test3依然会打印，不中断外部函数的调用

###### 对于4的事例

```kotlin
inline fun test1(l0:() -> Unit, noinline l1:() -> Unit): () -> Unit {
    l0.invoke()
    l1.invoke()
    return l1
}
```

如果不用noinline进行修饰的话，就会报错

main函数值就会被我们给改变了，就会导致我们的函数非法了，所以要加上noinline

##### kotlin的真泛型与实现方法

```kotlin
class Test<T> where T:CallBack , T:Runnable{
    fun add(t:T){
        t.run()
        t.callback()
    }

}
class A : CallBack ,Runnable{
    override fun callback() {
        println("A.callback")
    }

    override fun run() {
        println("A.run")
    }

}

interface CallBack{
    fun callback()
}

val test = Test<A>()
    test.add(A())
```

kotlin的真泛型


```java
public <T> T fromJson(String json,Class<T> classOff){
    
}
```

```kotlin
inline fun <reified T> Gson.fromJson(json:String) :T{
    return fromJson(json,T::class.java)
}
//inline是不能被省略的
```

让类也具有真泛型的功能

```kotlin
class View<T>(val clazz : Class<T>) {
    //运行时获取到class
    val presenter by lazy { clazz.newInstance() }
    companion object{
        inline operator fun <reified T> invoke() = View(T::class.java)
    }
}
class Presenter

fun main(args: Array<String>) {
    val p = View<Presenter>().presenter
}
```

#### Kotlin的扩展库

##### kotlinx.coroutines(协程库)

可控制

轻量级

语法糖

###### 启动协程

runBlocking

suspend,被suspend修饰的函数只能被suspend修饰的函数调用，因为suspend修饰的函数（或lambda）编译后会多一个参数类型的缴continuation，协程的异步调用本质上就是一次回调

##### kotlinx-io(io库)

##### AndroidKTX