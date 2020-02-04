package skiplist;
/**
 * SkipList
 * By Ferkhat "Faho" Shubladze
 *
 *
 * */
public class SkipList<T extends Comparable<T>> {
    private int maxLevel;
    private SkipNode<T> header;

    public SkipList(int maxLevel){
        if (maxLevel < 0){
            throw new IllegalArgumentException("Maximum level cannot be negative!");
        }
        this.maxLevel = maxLevel;
        header = new SkipNode<T>(null, maxLevel);

        SkipNode<T> end = new SkipNode<>(null, maxLevel); // Maybe make a singleton class for this sentinel?

        // Updating the empty header to point to the sentinel (because we have no other elements in the list (yet)
        for(int i = 0; i <= maxLevel; i++){
            header.forward[i] = end;
        }
    }


    public void insert(T data){
        int level = generateLevel();
        SkipNode node = new SkipNode(data, level);
        SkipNode[] update = new SkipNode[level+1];

        SkipNode curr = header;

        for(int i = level; i >= 0; i--){
            while((curr.forward[i] != null && curr.forward[i].data != null)
                    && curr.forward[i].data.compareTo(data) < 0){
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = node;
        for(int i = 0; i <= level; i++){
            curr.forward[i] = update[i].forward[i];
            update[i].forward[i] = curr;
        }
    }
    public boolean search(T key){
        if(key == null){
            throw new IllegalArgumentException("Data cannot be null!");
        }
        SkipNode curr = header;
        for(int i = maxLevel; i >= 0; i--){
            SkipNode next = curr.forward[i];
            while(next.data != null && next.data.compareTo(key) < 0){
                curr = next;
                next = curr.forward[i];
            }
        }

        curr = curr.forward[0];
        if(curr.data != null && curr.data.compareTo(key) == 0){
            return true;
        } else {
            return false;
        }
    }

    private int generateLevel(){
        int newLevel = 0;
        while (newLevel < maxLevel && Math.random() < 0.5){
            newLevel++;
        }
        return newLevel;
    }


    public T remove(T key){
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
