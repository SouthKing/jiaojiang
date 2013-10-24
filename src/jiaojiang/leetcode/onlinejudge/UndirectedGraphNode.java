package jiaojiang.leetcode.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Oct 23, 2013 10:13:52 PM
 */
public class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<UndirectedGraphNode>();
    }

    public static UndirectedGraphNode constructGraph() {
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        node.neighbors.add(node1);
        node.neighbors.add(node2);

        node1.neighbors.add(node2);
        
        node2.neighbors.add(node2);

        return node;
    }

    public void print() {
        
    }
}
