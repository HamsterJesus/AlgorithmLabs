import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class BinarySearchTree{
    Node root;

    public void insert(Node node){
       root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node){
        int data = node.data;

        if(root == null){ //if root is null
            root = node; //assign node to root as it must be the first 
            return root;
        } else if(data < root.data){//if data less than root
            root.left = insertHelper(root.left, node); //asign root 
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display(){
        displayHelper(root);
    }

    private void displayHelper(Node root){
        //method that prints nodes in ascending order
        if(root != null){ //if not null
            displayHelper(root.left); //pass in root childs left node
            System.out.println(root.data);
            displayHelper(root.right); //in order traversal all nodes displayed in none decreasing order
        }
    }

    public boolean search(int data){
        return searachHelper(root, data);

    }

    private boolean searachHelper(Node root, int data){
        //method that returns true if found, and false if not

        if(root == null){ //tree empty
            return false; //nothing to search
        } else if(root.data == data){ //if match found
            return true; //found
        } else if(root.data > data){ //if root larger than data
            return searachHelper(root.left, data); //search left child
        } else { //if root smaller than data
            return searachHelper(root.right, data); //search right child
        }
    }

    public void remove(int data){
        if(search(data)){ //check if data exists
            removeHelper(root, data);
        } else { //if data not found
            System.out.println(data + " could not be found");
        }
    }

    public Node removeHelper(Node root, int data){

        if(root == null){ //if root is empty
            return root;
        } else if(data < root.data){ //if data less than root use left child
            root.left = removeHelper(root.left, data);
        } else if (data > root.data){ //if data greater than root use right child
            root.right = removeHelper(root.right, data);
        } else {
            if(root.left == null && root.right == null){ //check if leaf node (no outgoing edges)
                root = null;
            } else if(root.right != null){ //find successor to replace right node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { //find predecessor to replace left node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, data);
            }
        }


        return root;
    }

    private int successor(Node root){ //find the least value below the right child of root node
        root = root.right; //assign root to right child 

        while(root.left != null){ //while not a leaf node
            root = root.left; //go as far left as possible
        }

        return root.data; //return lowest value
    }

    private int predecessor(Node root){ //find the greatest value below the left child of root node
        root = root.left; //assign root to left child 

        while(root.right != null){ //while not a leaf node
            root = root.right; //go as far right as possible
        }

        return root.data; //return highest value
    }
}