import java.util.Iterator;

public class RopeString implements Iterable{


    private RopeNode root;
    public RopeString(){

    }


    /** Returns the character at index i in O(logn)
     * @param i index of character
     * @return character at index i
     */
    public char index(int i){
        if(i < 0){
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

        return node.getString().charAt(i);
    }

    public void concatWith(RopeString other){
        RopeNode nRoot = new RopeNode(this.root, other.root);
        nRoot.setWeight(this.root.getLeft().getWeight() + this.root.getRight().getWeight());
        this.root = nRoot;
    }

    public RopeString split(int i){
        //throw new UnsupportedOperationException("Implement this method!");

        RopeNode curr = this.root;
        int idx = i;
        while(curr != null && curr.getWeight() < idx){
            // TODO
        }
        return null; // TODO
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
