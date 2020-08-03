package com.example.c4_coi

import com.example.c4_coi.accessModifiers.Button1
import com.example.c4_coi.accessModifiers.Button2
import com.example.c4_coi.constructorFun.Button3
import com.example.c4_coi.constructorFun.Button4
import com.example.c4_coi.constructorFun.User
import com.example.c4_coi.delegate.DelegatingCollection
import com.example.c4_coi.innerOrStatic.Outer
import com.example.c4_coi.innerOrStatic.VButton
import com.example.c4_coi.interfaceProperties.FacebookUser
import com.example.c4_coi.interfaceProperties.PrivateUser
import com.example.c4_coi.interfaceProperties.SubscribingUser
import com.example.c4_coi.obj.CaseInsensitiveFileComparator
import com.example.c4_coi.obj.Person
import com.example.c4_coi.sealedClass.Expr
import com.example.c4_coi.sealedClass.eval
import java.io.File

/**
 * @author ggz
 * @date 2020/7/28
 */
class Client(val name: String, val postalCode: Int) {
    override fun toString(): String = "Client(name=$name, postCode=$postalCode)"

    // 单单重写 equals 会破坏 hashCode
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) =
        Client(name, postalCode)
}

// equals 和 hashCode 会将所有主构造方法中的属性纳入考虑
data class Client2(val name: String, val postalCode: Int)


fun main(args: Array<String>) {
    println("-----------------------")
    // 访问修饰符：final、open、abstract、override
    // 接口中的成员始终是 open 的
    // 类中成员默认是 final，除非标明是 open
    // override 都是 open，除非标明是 final
    val button1 = Button1()
    button1.setFocus(true)
    button1.click()
    button1.showOff()
    val button2 = Button2()

    println("-----------------------")
    // 可见修饰符：public、internal、protected、private
    // public:      默认，所有地方可见
    // internal:    模块中可见
    // protected:   子类中可见
    // private:     类中可见(类成员)，文件中可见(顶层声明)

    println("-----------------------")
    // 内部类和嵌套类
    // 嵌套类(默认)，不持有外部类的引用
    // 内部类(inner),持有
    val vButton = VButton()
    val outer = Outer()

    println("-----------------------")
    // 密封类
    println(
        eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)))
    )

    println("-----------------------")
    // 构造函数
    val user = User("Jack")
    val button3 = Button3("ctx")
    val button4 = Button4("ctx")

    println("-----------------------")
    // 接口属性
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
    FacebookUser(123456789).address = "zhuhai"

    println("-----------------------")
    // 在 java ，可以使用 == 来比较基本数据类型和引用类型，
    // 基本数据类型比较的是值，引用类型比较的是引用。
    // 在 kotlin ，== 是比较对象的默认方式：本质上说它是
    // 通过调用 equals 比较两个值。=== 与 java 的比较对象引用效果一样
    val client1 = Client("Alice", 342562)
    val client2 = Client("Alice", 342562)
    println(client1 == client2)     // == 会编译成 equals

    // data 类的属性尽量保持不可变，特别是作为 HashMap 的键时
    val client3 = Client("Bob", 973293)
    println(client3.copy(postalCode = 382555))

    println("-----------------------")
    // by 关键字
    val list = arrayListOf(1, 2, 3)
    val delegatingCollection = DelegatingCollection(list)
    println(delegatingCollection.contains(3))
    println(delegatingCollection.contains(4))

    println("-----------------------")
    // object 关键字
    val file1 = File("/User")
    val file2 = File("/user")
    println(CaseInsensitiveFileComparator.compare(file1, file2))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
    // 简单单例可以这样创建，但是如需控制对象实例化，
    // 需要将依赖注入框架(Guice)与 kotlin 类一起使用
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    println("-----------------------")
    // 伴生对象，代替 Java 中的 static 方法，当然也能使用注解 @JvmStatic 来实现
    // 实现匿名内部类
    // 可以访问类中的私有成员和方法
    val subscribingUser = com.example.c4_coi.obj.User.newSubscribingUser("Bob@gmail.com")
    println(subscribingUser.nickname)
}