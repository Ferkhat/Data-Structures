public class RopeNode {

    private RopeNode left, right;
    private String string = "";
    private int weight = 0;


    public RopeNode(String s){
        this.string = s;
        this.weight = s.length();
    }

    public RopeNode(RopeNode l, RopeNode r){
        if(this.left == null) {
            throw new IllegalArgumentException("Left node should not be null!");
        }
        this.left = l;
        this.right = r;
        this.weight = this.left.weight;
    }


    public void setLeft(RopeNode n){
        this.left = n;
    }

    public void setRight(RopeNode n){
        this.right = n;
    }

    public RopeNode getLeft(){
        return this.left;
    }

    public RopeNode getRight(){
        return this.right;
    }

    public void setWeight(int w){
        this.weight = w;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setString(String s){
        this.string = s;
    }

    public String getString(){
        return this.string;
    }


    public boolean isLeaf(){
        return left == null && right == null;
    }
}
