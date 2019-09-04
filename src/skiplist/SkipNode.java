package skiplist;

public class SkipNode<T extends Comparable<T>> {
    T data;
    SkipNode<T> forward[]; //rename

    public SkipNode(T data, int level){
        this.data = data;
        forward = new SkipNode[level+1];
    }


    
}
