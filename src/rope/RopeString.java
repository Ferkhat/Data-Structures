package rope;

import java.util.Iterator;

public class RopeString implements Iterable{


    //TODO: change to private
    public RopeNode root;
    private int length = 999; //TODO: change
    public RopeString(){

    }

    /** Returns the character at index i in O(logn)
     * @param i index of character
     * @return character at index i
     */
    public char index(int i){
        if(i <= 0 || i > length){
            throw new IllegalArgumentException("Index cannot be negative");
        }
        return indexAux(this.root, i);
    }

    private char indexAux(RopeNode node, int i){
        if(!node.isLeaf() && node.getWeight() < i){
            return indexAux(node.getRight(), i - node.getWeight());
        } else if(!node.isLeaf()){
            return indexAux(node.getLeft(), i);
        }

        return node.getString().charAt(i-1);
    }

    public void concatWith(RopeString other){
        RopeNode nRoot = new RopeNode(this.root, other.root);
        nRoot.setWeight(this.root.getLeft().getWeight() + this.root.getRight().getWeight());
        this.root = nRoot;
    }


    /**
     * Splits the current RopeString into two halves depending on the value of i.
     * The current object becomes the left side of the split, while the method returns the right side.
     *
     * @param i
     * @return A RopeString object that represents the right side of the split
     */
public RopeNode[] split(int i){
        RopeNode left;
        RopeNode right = new RopeNode();
        left = splitAux(i, root, right);
        return new RopeNode[] {left, right};
    }

    private RopeNode splitAux(int i, RopeNode curr, RopeNode right){
        if(curr.isLeaf()){
            if(i <= curr.getWeight()){
                RopeNode l, r;
                l = new RopeNode(curr.getString().substring(0, i));
                r = new RopeNode(curr.getString().substring(i, curr.getWeight()));
                curr.setChildren(l,null);
                if(!r.getString().equals("")){
                    right.concatLeft(r);
                }
                curr = curr.reduce();
                return curr;
            } else {
                return curr;
            }
        } else {
            if(curr.getWeight() < i){ //going right
                RopeNode next;
                next = splitAux(i - curr.getWeight(), curr.getRight(), right);
                curr.setRight(next);
                curr = curr.reduce();
                return curr;
            } else { //going left
                RopeNode next;
                if(curr.getRight() != null) {
                    right.concatLeft(curr.getRight());
                    curr.setRight(null);
                }
                next = splitAux(i, curr.getLeft(), right);
                curr.setLeft(next);
                curr = curr.reduce();
                return curr;
            }
        }
    }
    public void insert(int i, String s){
        throw new UnsupportedOperationException("Implement this method!");


    }

    public void delete(int start, int end){ // maybe return the substring?
        throw new UnsupportedOperationException("Implement this method!");
    }

    public String report(int start, int end){
        throw new UnsupportedOperationException("Implement this method!");
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
