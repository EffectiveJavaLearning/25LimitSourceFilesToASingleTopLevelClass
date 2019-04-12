package badexample;

/**
 * 举例说明为什么不要一个源文件放多个顶层类
 *
 * @author LightDance
 * @date 2018/9/15
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
}

