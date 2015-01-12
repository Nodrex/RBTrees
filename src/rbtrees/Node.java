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
public class Node {

    public static final Node sentinel = new Node();//fictional node

    private boolean isSentinelNode;

    public boolean isSentinel() {
        return isSentinelNode;
    }

    Color color = Color.Black;

    double key;//this should be generic for future.

    Node left;
    Node right;
    Node parent;

    public Node(double key) {
        this.key = key;
    }

    private Node() {
        isSentinelNode = true;
    }
}
