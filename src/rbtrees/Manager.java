/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtrees;

/**
 *
 * @author NODREX
 */
public class Manager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        
        RBTree rBTree = new RBTree();
        
       // try {
            
//            rBTree.insert(new Node(25));
//            rBTree.insert(new Node(35));
//            rBTree.insert(new Node(-5));
//            rBTree.insert(new Node(26));
//            rBTree.insert(new Node(27));
//            rBTree.insert(new Node(75));
//            rBTree.insert(new Node(20));
//            rBTree.insert(new Node(78));
//            rBTree.insert(new Node(85));
//            rBTree.insert(new Node(35));
//            rBTree.insert(new Node(27));
//            rBTree.insert(new Node(-1));
//            rBTree.insert(new Node(-4));
//            rBTree.insert(new Node(0));
//            rBTree.insert(new Node(0));
//            rBTree.insert(new Node(-5));
//            rBTree.insert(new Node(28));
//            rBTree.insert(new Node(100));
//            rBTree.insert(new Node(-20));
//            rBTree.insert(new Node(26));
//            rBTree.insert(new Node(15));
//            rBTree.insert(new Node(15));
//            rBTree.insert(new Node(10));
//            rBTree.insert(new Node(0));
//            rBTree.insert(new Node(27));
        
        
        rBTree.insert(new Node(1));
        rBTree.insert(new Node(2));
        rBTree.insert(new Node(3));
        rBTree.insert(new Node(4));
        rBTree.insert(new Node(5));
        rBTree.insert(new Node(6));
        rBTree.insert(new Node(7));
       
        
        
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
        
        System.out.println(rBTree.size);
            
        System.out.println(rBTree);
        
    }
    
}
