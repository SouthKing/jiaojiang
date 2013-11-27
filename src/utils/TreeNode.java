package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Nov 27, 2013 1:43:49 PM
 */
public class TreeNode {
    protected int value;
    protected List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        children = null;
    }

    public void addChild(TreeNode childNode) {
        if (children == null) {
            children = new ArrayList<TreeNode>();
        }

        children.add(childNode);
    }
}
