package rbtrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author NODREX
 */
public class RBTree {

    Node node;//This is root node. (this.nod is same as this.root.node)
    RBTree root;//root is alwais black.
    
    int size;

    protected void insert(Node newNode) throws CloneNotSupportedException {
        size++;
        if (root == null) {
            root = this;
            root.node = newNode;
            root.node.parent = Node.sentinel;
            root.node.left = Node.sentinel;
            root.node.right = Node.sentinel;
            return;
        }
        Node tmpNode = root.node;
        while (true) {
            if (newNode.key < tmpNode.key) {
                if (tmpNode.left == Node.sentinel) break;
                tmpNode = tmpNode.left;
            } else {
                if (tmpNode.right == Node.sentinel) break;
                tmpNode = tmpNode.right;
            }
        }
        newNode.parent = tmpNode;
        if (newNode.key < tmpNode.key) {
            tmpNode.left = newNode;
        } else {
            tmpNode.right = newNode;
        }
        
        newNode.left = Node.sentinel;
        newNode.right = Node.sentinel;
        newNode.color = Color.Red;
        
        insertFixup(newNode);
    }
    
    private void insertFixup(Node newNode) {
        while (newNode.parent.color == Color.Red) {
            if (newNode.parent == newNode.parent.parent.left) {
                Node tmpNode = newNode.parent.parent.right;
                if (tmpNode.color == Color.Red) {
                    newNode.parent.color = Color.Black;
                    tmpNode.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    newNode = newNode.parent.parent;
                } else {
                    if (newNode == newNode.parent.right) {
                        newNode = newNode.parent;
                        rotateL(newNode);
                    }
                    newNode.parent.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    rotateR(newNode.parent.parent);
                }
            } else if (newNode.parent == newNode.parent.parent.right) {
                Node y = newNode.parent.parent.left;
                if (y.color == Color.Red) {
                    newNode.parent.color = Color.Black;
                    y.color = Color.Black;
                    newNode.parent.parent.color = Color.Red; 
                    newNode = newNode.parent.parent;
                } else {
                    if (newNode == newNode.parent.left) {
                        newNode = newNode.parent;
                        rotateR(newNode);
                    }
                    newNode.parent.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    rotateL(newNode.parent.parent);
                }
            }
        }
        this.root.node.color = Color.Black;
    }

    private void rotateL(Node node) {
        Node tmpNode = node.right;
        node.right = tmpNode.left;

        if(tmpNode.left != null){
            tmpNode.left.parent = node;
        }

        tmpNode.parent = node.parent;
        if (node.parent == Node.sentinel) {
            this.root.node = tmpNode;
        } else {
            if (node == node.parent.left) {
                node.parent.left = tmpNode;
            } else {
                node.parent.right = tmpNode;
            }
        }
        tmpNode.left = node;
        node.parent = tmpNode;
    }

    private void rotateR(Node node) {
        Node tmpNode = node.left;
        node.left = tmpNode.right;

        if(tmpNode.right != null){
            tmpNode.right.parent = node;
        }

        tmpNode.parent = node.parent;

        if (node.parent == Node.sentinel) {
            this.root.node = tmpNode;
        } else {
            if (node == node.parent.right) {
                node.parent.right = tmpNode;
            } else {
                node.parent.left = tmpNode;
            }
        }
        tmpNode.right = node;
        node.parent = tmpNode;
    }

    @Override
    public String toString() {
        printTree(node);
        return "";        
    }
    
    public void printTree(Node rootNode) {

        List<Node> topLevel = new ArrayList<>();
        List<Node> bottomLevel = new ArrayList<>();

        topLevel.add(rootNode);

        while (!topLevel.isEmpty()) {
            for (Node currentNode : topLevel) {
                if (currentNode.left != null) {
                    bottomLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    bottomLevel.add(currentNode.right);
                }
                System.out.print(currentNode.key + " " + currentNode.color +" ");
            }
            System.out.println();
            topLevel = bottomLevel;
            bottomLevel = new LinkedList<>();
        }

    }
    
}
