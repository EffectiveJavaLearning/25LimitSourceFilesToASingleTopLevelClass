/**
 * Java编译器是允许在一个源文件中定义多个顶层类的，但这么做也存在风险，即：
 * 有可能为一个类提供多种实现，而具体会调用哪种实现受源文件被编译器编译时的编译顺序影响。
 *
 * 比如这个例子：Main.java的代码中使用了Utensil.java 两个类中的NAME字段，希望将它们打印出来。
 * 运行{@link badexample.Main#main(String[])}，则会打印出pancake. 但如果我们一不小心添加了
 * 两个同名的类，放在了Dessert.java 文件中，会怎么样？
 *
 * 如果用的是IDEA等比较高级的编译器，那么检测机制会提示duplicate class found,但如果用的是txt啥的，
 * 然后命令行编译，那么会有风险的。
 *
 * 比如javac Main.java Dessert.java,编译后运行的结果是potpie，而
 * javac Main.java Utensil.java的编译后运行结果则是pancake.
 * 但如果直接javac Main.java，那么编译后运行的结果，在我这里试出来的结果似乎跟之前（上一个）
 * 编译的文件有关，比如上一次编译过javac Main.java Dessert.java，然后javac Main.java，就是potpie;
 * 上一次编译过javac Main.java Utensil.java，然后javac Main.java，就是pancake.
 *
 *
 * 防止该风险的方式也不难，还拿这个例子来说，只需将Dessert和Utensils两个类设置为静态成员类，
 * 放在Main类里面即可，就像下面这样。(打印结果：pie(from inner class)pot(from inner class))
 *
 * 因此，千万别把多个顶级类或者接口放在一个源文件里面，以防多个同名class掺着编译顺序把你搞蒙逼。
 *
 * @author LightDance
 * @date 2018/9/15
 */
public class LimitSourceFilesToSingleTopLevelClass {
    private static class Dessert{
        static final String NAME = "pot(from inner class)";
    }

    private static class Utensil{
        static final String NAME = "pie(from inner class)";
    }

    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);

    }
}
