package rbtrees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author NODREX
 */
public class RBTree {

    Node node;//This is root node. (this.nod is same as this.root.node)
    RBTree root;//root is alwais black.
    
    int size;

    protected void insert(Node z) throws CloneNotSupportedException {
        size++;
        if (root == null) {
            root = this;
            root.node = z;
            root.node.parent = Node.sentinel;
            root.node.left = Node.sentinel;
            root.node.right = Node.sentinel;
            return;
        }
        Node y = root.node;
        while (true) {
            if (z.key < y.key) {
                if (y.left == Node.sentinel) break;
                y = y.left;
            } else {
                if (y.right == Node.sentinel) break;
                y = y.right;
            }
        }
        z.parent = y;
        if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        
        z.left = Node.sentinel;
        z.right = Node.sentinel;
        z.color = Color.Red;
        
        insertFixup(z);
    }
    
    private void insertFixup(Node z) {
        while (z.parent.color == Color.Red) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y.color == Color.Red) {
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    z.parent.parent.color = Color.Red;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        rotateL(z);
                    }
                    z.parent.color = Color.Black;
                    z.parent.parent.color = Color.Red;
                    rotateR(z.parent.parent);
                }
            } else if (z.parent == z.parent.parent.right) {
                Node y = z.parent.parent.left;
                if (y.color == Color.Red) {
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    z.parent.parent.color = Color.Red; 
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        //rotateL(newNode);
                        //rotateR(newNode.parent.parent);
                        rotateR(z);
                    }
                    z.parent.color = Color.Black;
                    z.parent.parent.color = Color.Red;
                    //rotateR(newNode.parent.parent);
                    //rotateL(newNode);
                    rotateL(z.parent.parent);
                }
            }
        }
        this.root.node.color = Color.Black;
    }

    private void rotateL(Node x) {
        Node y = x.right;
        x.right = y.left;

        if(y.left != null){
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == Node.sentinel) {
            this.root.node = y;
        } else {
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    private void rotateR(Node x) {
        Node y = x.left;
        x.left = y.right;

        if(y.right != null){
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == Node.sentinel) {
            this.root.node = y;
        } else {
            if (x == x.parent.right) {
                x.parent.right = y;
            } else {
                x.parent.left = y;
            }
        }
        y.right = x;
        x.parent = y;
    }

    @Override
    public String toString() {
        printTree(node);
        return "";        
       // return print(node);
    }

    public void printTree(Node root) {

        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.key + " " + currentNode.color +" ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();

        }

    }
    
}
