package jiaojiang.misc;

/**
 * @author: mizhang
 * @since: Aug 7, 2013 3:16:26 PM
 */
public class HousePainter {

    public static int paintHouses(int[][] costs) {

        

        return 0;
    }

    public static int[][] getCostArray() {
        return new int[][]{
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 1},
                {2, 1, 4}
        };
    }

    public static int[][] getCostArray2() {
        return new int[][] {
                {2, 2, 1},
                {1, 2, 3}
        };
    }

    public static void test() {
        System.out.println(paintHouses(getCostArray()));
        System.out.println(paintHouses(getCostArray2()));
    }

    public static void main(String[] args) {
        test();
    }
    
}
