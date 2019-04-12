package badexample;

/**
 * 举例说明为什么不要一个源文件放多个顶层类，更改了NAME字段，由于编译器会自动检测重名，
 * 因此把这个类打了注释
 *
 * @author LightDance
 * @date 2018/9/15
 */

/*class Utensil{
    static final String NAME = "pot";
}

class Dessert{
    static final String NAME = "pie";
}*/