package rbtrees;

/**
 *
 * @author NODREX
 *
 * fesvi yoveltvis shavia.
 */
public class RBTree {

    Node node;//this will be root node always. (this.nod is same as this.root.node)
    RBTree root;
    
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
    
    private void insertFixup(Node newNode){
        while (newNode.parent.color == Color.Red) { 
            if(newNode.parent == newNode.parent.parent.left){
                Node tmpNode = newNode.parent.parent.right;
                if(tmpNode.color == Color.Red){
                    newNode.parent.color = Color.Black;
                    tmpNode.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    newNode = newNode.parent.parent;
                }else{
                    if(newNode == newNode.parent.right){
                        newNode = newNode.parent;
                        rotateL(newNode);
                    }
                    newNode.parent.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    rotateR(newNode.parent.parent);
                }
            }else if(newNode.parent == newNode.parent.parent.right){
                Node tmpNode = newNode.parent.parent.left;
                if(tmpNode.color == Color.Red){
                    newNode.parent.color = Color.Black;
                    tmpNode.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    newNode = newNode.parent.parent;
                }else{
                    if(newNode == newNode.parent.left){
                        newNode = newNode.parent;
                        //rotateL(newNode);
                        rotateR(newNode.parent.parent);
                    }
                    newNode.parent.color = Color.Black;
                    newNode.parent.parent.color = Color.Red;
                    //rotateR(newNode.parent.parent);
                    rotateL(newNode);
                }
            }
        }
        root.node.color = Color.Black;
    }
    
//    private void rotateL(Node newNode) {
//        Node tmpNode = newNode.right;
//        newNode.right = tmpNode.left;
//        tmpNode.left.parent = newNode;
//        tmpNode.parent = newNode.parent;
//        if(newNode.parent == Node.sentinel){
//            this.root.node = tmpNode;
//        }else{
//            if(newNode == newNode.parent.left){
//                newNode.parent.left = tmpNode;
//            }else{
//                newNode.parent.right = tmpNode;
//            }
//        }
//        tmpNode.left = newNode;
//        newNode.parent = tmpNode;
//    }
    
    
        private void rotateL(Node newNode) {
        Node tmpNode = newNode.right;
        newNode.right = tmpNode.left;
        
//        if(tmpNode.left != Node.sentinel){
//            tmpNode.left.parent = newNode;
//        }
        
        tmpNode.left.parent = newNode;
        
        tmpNode.parent = newNode.parent;
        if(newNode.parent == Node.sentinel){
            this.root.node = tmpNode;
        }else{
            if(newNode == newNode.parent.left){
                newNode.parent.left = tmpNode;
            }else{
                newNode.parent.right = tmpNode;
            }
        }
        tmpNode.left = newNode;
        newNode.parent = tmpNode;
    }
        
            private void rotateR(Node newNode) {
        Node tmpNode = newNode.left;
        newNode.left = tmpNode.right;
        
//        if(tmpNode.right != Node.sentinel){
//            tmpNode.right.parent = newNode;
//        }
        

tmpNode.right.parent = newNode;

        
        
        tmpNode.parent = newNode.parent;
        
        if(newNode.parent == Node.sentinel){
            this.root.node = tmpNode;
        }else{
            if(newNode == newNode.parent.right){
                newNode.parent.right = tmpNode;
            }else{
                newNode.parent.left = tmpNode;
            }
        }
        tmpNode.right = newNode;
        newNode.parent = tmpNode;
    }
        

//    private void rotateR(Node newNode) {
//        Node tmpNode = newNode.left;
//        newNode.left = tmpNode.right;
//        tmpNode.right.parent = newNode;
//        tmpNode.parent = newNode.parent;
//        
//        if(newNode.parent == Node.sentinel){
//            this.root.node = tmpNode;
//        }else{
//            if(newNode == newNode.parent.right){
//                newNode.parent.right = tmpNode;
//            }else{
//                newNode.parent.left = tmpNode;
//            }
//        }
//        tmpNode.right = newNode;
//        newNode.parent = tmpNode;
//    }
       
   
    
    @Override
    public String toString() {
        //return "";        
        return print(node);
    }
    
    String print(Node node){
        if(node.isSentinel()) return "";
        
        String parent = node.key +" " + node.color + "\n";
        String left = print(node.left);
        String right =print(node.right);
      
        String result = parent + left + " " + right;
        return result;
    }

}
