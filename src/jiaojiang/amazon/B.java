package jiaojiang.amazon;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Aug 14, 2010
 * Time: 9:57:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class B extends A{
    public void printIt() {
        System.out.println("This is subclass");
    }

    public static void main(String[] argv) {
        A a = new B();
        a.printIt();
        a.printIt(true);
        a.printIt(false);

        A b = new A();
        b.printIt(false);
    }
}
