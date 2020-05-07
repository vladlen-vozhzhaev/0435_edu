/* Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace. */

public class Main {
    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
    }

    public static String method2() {
        method3();
        //напишите тут ваш код
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
    }

    public static String method5() {
        //напишите тут ваш код
    }
}
