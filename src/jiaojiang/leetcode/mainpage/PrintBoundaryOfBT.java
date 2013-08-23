package jiaojiang.leetcode.mainpage;

import jiaojiang.leetcode.onlinejudge.TreeNode;
import jiaojiang.leetcode.onlinejudge.RecoverBST;

import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Aug 23, 2013 5:24:08 PM
 */
public class PrintBoundaryOfBT {

    public static void printBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        
        List<Boolean> leafOnly = new ArrayList<Boolean>();
        leafOnly.add(false);
        printLeftBoundary(root.left, leafOnly);

    }

    public static void printLeftBoundary(TreeNode root, List<Boolean> leafOnly) {
        if (root == null) {
            return;
        }

        if (!leafOnly.get(0)) {
            System.out.println(root.val);
            if (root.left == null && root.right == null) {
                leafOnly.set(0, true);
            }
            printLeftBoundary(root.left, leafOnly);
            printLeftBoundary(root.right, leafOnly);
        } else {
            if (root.left == null && root.right == null) {
                System.out.println(root.val);
            }
            printLeftBoundary(root.left, leafOnly);
            printLeftBoundary(root.right, leafOnly);
        }
    }

    public static void printRightBoundary(TreeNode root, TreeNode startNode) {

    }

    public static void test() {
        printBoundary(RecoverBST.constructTree());  //
        System.out.println("--------5, 3, 10, 4 -- 7, 2, 8--------");
        printBoundary(RecoverBST.constructTree2());
        System.out.println("--------2 -- 1--------");
        printBoundary(RecoverBST.constructTree3());
        System.out.println("--------64, 41, -85, -73, -98, -124, -49 -- null --------");
    }

    public static void main(String[] args) {
        test();
    }

}
