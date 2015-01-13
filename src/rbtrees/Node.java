
package rbtrees;

/**
 *
 * @author NODREX
 */
public class Node {

    public static final Node sentinel = new Node();//fictional node.
    private boolean isSentinelNode;
    
    //double data; //this should be geneic data for future.
    double key;//this should be generic for future.
    Color color = Color.Black;
    Node left;
    Node right;
    Node parent;

    private Node() {
        isSentinelNode = true;
    }
    
    public Node(double key) {
        this.key = key;
    }
    
    public boolean isSentinel() {
        return isSentinelNode;
    }
    
}
