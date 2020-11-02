package com.example.c4_coi.innerOrStatic

/**
 * @author ggz
 * @date 2020/7/29
 */
class VButton : View {

    override fun getCurrentState(): State =
        VButtonState()

    override fun restoreState(state: State) {}

    /**
     * java 语法中
     * VButtonState 声明中如果没带 static，默认变成内部类，不是静态嵌套类
     * VButtonState 类隐式地存储了外部类 VButton 的引用，
     * 所以 VButtonState 会出现不可被序列化的异常。
     *
     * kotlin 语法中
     * 与 java 相反，VButtonState 默认就是嵌套类，与 java 的静态嵌套类类似
     * */
    // 嵌套类(默认)，不持有外部类的引用
    class VButtonState : State {}
    // 内部类(inner),持有外部类的引用
//    inner class VButtonState : State {}
}