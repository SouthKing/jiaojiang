package companies.twitter.mitbbs;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Feb 20, 2013 12:35:06 AM
 */
public class Tree<T> {

    protected TreeNode<T> root;

    public static class TreeNode<T>{
        protected T value;
        protected List<TreeNode<T>> children;

        public TreeNode(T t) {
            value = t;
            children = null;
        }

        public void addChild(TreeNode<T> node) {
            if (children == null) {
                children = new ArrayList<TreeNode<T>>();
            }

            children.add(node);
        }
    }

    public static Tree<Integer> getSampleTree() {
        Tree<Integer> tree = new Tree<Integer>();
        tree.root = new TreeNode<Integer>(1);

        tree.root.addChild(new TreeNode<Integer>(8));
        tree.root.addChild(new TreeNode<Integer>(7));

        tree.root.children.get(0).addChild(new TreeNode<Integer>(9));
        tree.root.children.get(0).addChild(new TreeNode<Integer>(4));

        tree.root.children.get(1).addChild(new TreeNode<Integer>(3));

        tree.root.children.get(0).children.get(0).addChild(new TreeNode<Integer>(6));
        tree.root.children.get(1).children.get(0).addChild(new TreeNode<Integer>(5));

        return tree;
    }

    public static int getNumber(TreeNode<Integer> node, List<Integer> list) {

        int ret = 0;

        list.add(node.value);

        if (node.children == null) {
            int sum = 0;
            for (Integer value : list) {
                sum = sum * 10 + value;
            }
            return sum;
        }

        for (TreeNode<Integer> treeNode : node.children) {
            ret += getNumber(treeNode, list);
            list.remove(list.size() - 1);
        }
        return ret;
    }

    public static void testGetNumber() {
        Tree<Integer> tree = getSampleTree();
        System.out.println(getNumber(tree.root, new ArrayList<Integer>()));
    }

    public static void main(String[] args) {
        testGetNumber();

    }

}
