package uk.ac.rgu.cm2116;

import java.util.ArrayList;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size;

    private ArrayList<Node<K, V>> traversal; //holds the in-order traversal

    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
        this.traversal = new ArrayList<>();
    }

    /**
     * Method to perform an in-order traversal of this BST
     * @return
     */
    public ArrayList<Node<K, V>> traverse(){
        this.traversal = new ArrayList<>();
        this.traverse(this.root);
        return this.traversal;
    }

    /**
     * Method to recursively traverse the (sub-)tree rooted at the given node
     * @param node
     */
    private void traverse(Node<K, V> node){
        if(node != null){
            traverse(node.getLeft());
            traversal.add(node);
            traverse(node.getRight());
        }
    }

    /**
     * Method to put the given value at the given key
     * Wrapper for the recursive put() method, passing the root
     * Returns true on success, or false if they key already exists
     * @param key
     * @param value
     * @return
     */
    public boolean put(K key, V value){
        if(this.root == null){
            this.root = new Node<>(key, value);
            return true;
        }
        return this.put(key, value, this.root);
    }

    /**
     * Recursively try to put the given key=value into the (sub-)tree rooted at the given node
     * @param key
     * @param value
     * @param node
     * @return
     */
    private boolean put(K key, V value, Node<K, V> node){
        if(this.root != null && key != null){ //make sure root and key aren't null
            if(key.equals(node.getKey())){ //check for duplicate key
                return false;
            };


            if(key.compareTo(node.getKey()) < 0){ //if value of key is < value of node
                if(node.getLeft() == null){ //if left isn't occupied
                    node.setLeft(new Node<>(key, value));
                    return true;
                } else{ //if left is occupied
                    return this.put(key, value, node.getLeft()); //recursive put
                }
                
            } else{ //if greater than
                if(node.getRight() == null){ //if right isn't occupied
                node.setRight(new Node<>(key, value));
                return true;
            } else{ //if right is occupied
                return this.put(key, value, node.getRight()); //recursive put
            }
            }
        }
        return false;
    }

    /**
     * Method to remove the value at the given key
     * @param key
     * @return
     */
    public void remove(K key){
        if(this.root != null && key != null){
            this.root = this.remove(key, this.root);
        }
    }

    /**
     * Recursively tries to remove the given key from this tree,
     * or returns null if the key does not exist
     * @param node
     * @return
     */
    private Node<K, V> remove(K key, Node<K, V> node){
        if(key != null && node != null){
            if(key.equals(node.getKey())){
                if(node.getLeft() == null && node.getRight() == null){ //if the node has no children
                    return null;
                } else if (node.getLeft() != null && node.getRight() == null){ //if one child on left
                    return node.getLeft();
                } else if (node.getRight() != null && node.getLeft() == null){ //if one child on right
                    return node.getRight(); 
                } else { //if left and right child
                    Node<K,V> temp = node.getSuccessor(); 

                    this.remove(temp.getKey(), node);

                    temp.setRight(node.getRight());
                    temp.setLeft(node.getLeft());
                } 
            } else if(key.compareTo(node.getKey()) < 0 && node.getLeft() != null){
                node.setLeft(this.remove(key, node.getLeft()));
            } else if(key.compareTo(node.getKey()) < 0 && node.getRight() != null){
                node.setRight(this.remove(key, node.getRight()));
            }
        }

        return node;
    }

    /**
     * Get the value at the given key, or null if the key isn't in this tree
     * @param key
     * @return
     */
    public V get(K key){
        return null;
    }

    /**
     * Contains is a wrapper for get that returns true if we don't get null back
     * @param key
     * @return
     */
    public boolean contains(K key){
        return (this.get(key) != null);
    }

    /**
     * Returns the balance factor for this tree
     * @return
     */
    public int getBalanceFactor(){
        return (this.root != null) ? this.root.getBalanceFactor() : 0;
    }

    /**
     * Returns true if this tree is balanced
     * @return
     */
    public boolean isBalanced(){
        return (this.getBalanceFactor() <= 1 && this.getBalanceFactor() >= -1);
    }
       
    /* Rotation-based balancing methods below  */

    /**
     * Method to balance this BST through rotation
     */
    public void balanceRotate(){
        this.root = this.balanceRotate(this.root);
    }

    /**
     * Helper method to balance the (sub-)tree with the given node at its root, through rotation
     * @param node
     * @return
     */
    private Node<K, V> balanceRotate(Node<K, V> node){
        if(node.getBalanceFactor() > 1){
            return this.rotateRight(node);
        }else if(node.getBalanceFactor() < -1){
            return this.rotateLeft(node);
        }

        return node; //if we get this far, we don't need to do anything
    }

    /**
     * Helper method to rotate left about the given node
     * @param node
     * @return
     */
    private Node<K, V> rotateLeft(Node<K, V> node){
        return node;
    }

    /**
     * Helper method to rotate right about the given node
     * @param node
     * @return
     */
    private Node<K, V> rotateRight(Node<K, V> node){
        return node;
    }

    /* Traverse-then-divide balancing methods below */

    /**
     * Method to balance this BST using traverse-then-divide
     * The initial call to the recursive methods accepts the full range of indices in
     * the traversal ArrayList, i.e. 0 to size() - 1
     */
    public void balanceTraverse(){
        this.traverse();
        this.root = this.balanceTraverse(0, this.traversal.size() - 1);
    }

    /**
     * Recursive method to balance this BST through dividing an in-order traversal
     * low and high represent the bounds of the (sub-)ArrayList that will be considered
     * at each call of the method
     * @param low
     * @param high
     * @return
     */
    private Node<K, V> balanceTraverse(int low, int high){
        return this.root;
    }

    /**
     * Get the size of this BST
     * @return
     */
    public int getSize(){
        return this.size;
    }
    
}
