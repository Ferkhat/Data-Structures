package rope;

public class RopeNode{

    private RopeNode left, right;
    private String string = "";
    private int weight = 0;
    //TODO: set relevant method visibilities to protected (


    public RopeNode(){
        this.weight = 0;
    }
    public RopeNode(String s){
        this.string = s;
        this.weight = s.length();
    }

    //Copy constructor
    public RopeNode(RopeNode other){
        this.left = other.left;
        this.right = other.right;
        this.weight = other.weight;
        this.string = other.string;
    }

    public RopeNode(RopeNode l, RopeNode r){
//        if(this.left == null) {
//            throw new IllegalArgumentException("Left node should not be null!");
//        }
        this.left = new RopeNode(l);
        this.right = new RopeNode(r);
        this.weight = this.left.weight;
    }


    public void setLeft(RopeNode n){
        this.left = n;
        this.weight = n.weight;
        if(n.right != null){
            this.weight += n.right.weight;
        }
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

    public void setChildren(RopeNode l, RopeNode r) throws IllegalStateException{
        if(this.isLeaf()){
            this.left = l;
            this.right = r;
            this.weight = l.weight;
            this.string = "";
        } else {
            throw new IllegalStateException("This node has to be a leaf node");
        }
    }

    public void concatLeft(RopeNode other){
        RopeNode par = new RopeNode(other,this);
        this.left = par.left;
        this.right = par.right;
        this.recalculateWeights();
    }
    public boolean isLeaf(){
        return left == null && right == null;
    }

    public void recalculateWeights(){
        this.weight = 0;
        if(this.left != null){
            this.weight += this.left.weight;
            if(this.left.right != null){
                this.weight += this.left.right.weight;
            }
        }
    }
    public RopeNode reduce(){
        if(!this.isLeaf() ){
            if((this.left == null || this.left.isDead()) && !this.right.isDead()){
                return this.right;
            }
            if((this.right == null || this.right.isDead()) && !this.left.isDead()){
                return this.left;
            }
        } else {
            return this;
        }
        return this;
    }

    public boolean isDead(){
        return this.left == null && this.right == null && "".equals(this.string);
    }
}
