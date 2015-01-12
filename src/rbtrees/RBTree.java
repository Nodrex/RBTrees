package rbtrees;

/**
 *
 * @author NODREX
 *
 * fesvi yoveltvis shavia.
 */
public class RBTree {

    Node node;//es iqneba fesvis kvandzi yoveltvis. (this.nod igivea rac this.root.node)
    RBTree root;
    
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
        //return "";        
        return print(node);
    }

    
    
    String print(Node node) {
       
        if (node.isSentinel()) {
            return "";
        }

        String parent = node.key + " " + node.color + "\n" + getJoinedChildren(node) +"\n";
      
        String left ="";
        String right ="";
     
        left = /*print(node.left); */ getJoinedChildren(node.left);
        right = /* print(node.right); */ getJoinedChildren(node.right);
        
        String result = parent + left + " " + right;
        return result;
    }
    
    String getJoinedChildren(Node node){
        try{
            return node.left.key +" " + node.left.color + "     " + node.right.key + " " +   node.right.color;
        }catch(Exception e){}
        return "";
    }
    
    
    void f(){
         
    }

}
