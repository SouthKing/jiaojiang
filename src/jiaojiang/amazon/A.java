package jiaojiang.amazon;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Aug 14, 2010
 * Time: 9:55:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class A {

    public void printIt() {
        System.out.println("This is super class");
    }

    public void printIt(boolean yes) {
        if (yes) {
            System.out.println("This is super class II");
        } else {
            this.printIt();
        }
    }
}
