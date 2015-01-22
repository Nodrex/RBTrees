
package rbtrees;

/**
 *
 * @author NODREX
 */
public class Main {

    public static void main(String[] args) {
        
        RBTree rBTree = new RBTree();
            
        rBTree.insert(new Node(25));
        rBTree.insert(new Node(35));
        rBTree.insert(new Node(26));
        rBTree.insert(new Node(27));
        rBTree.insert(new Node(75));
        rBTree.insert(new Node(20));
        rBTree.insert(new Node(78));
        rBTree.insert(new Node(85));
        rBTree.insert(new Node(35));
        rBTree.insert(new Node(27));
            
        
//        rBTree.insert(new Node(1));
//        rBTree.insert(new Node(2));
//        rBTree.insert(new Node(3));
//        rBTree.insert(new Node(4));
//        rBTree.insert(new Node(5));
//        rBTree.insert(new Node(6));
//        rBTree.insert(new Node(7));
        
       
//        rBTree.insert(new Node(50));
//        rBTree.insert(new Node(49));
//        rBTree.insert(new Node(48));
//        rBTree.insert(new Node(47));
//        rBTree.insert(new Node(46));
//        rBTree.insert(new Node(45));
//        rBTree.insert(new Node(44));
//        rBTree.insert(new Node(43));
//        rBTree.insert(new Node(42));
//        rBTree.insert(new Node(41));
//        rBTree.insert(new Node(40));
//        rBTree.insert(new Node(39));

            
        System.out.println(rBTree);
        
        System.out.println();
        System.out.println("size: " + rBTree.size);
        
    }
    
}
