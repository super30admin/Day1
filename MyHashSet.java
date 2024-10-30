//https://leetcode.com/problems/design-hashset/
public class MyHashSet {
    int primarySize ;
    int secondarySize;
    boolean[][] data;

    public MyHashSet() {
        this.primarySize = 1001;
        this.secondarySize = 1000;
        this.data = new boolean[primarySize][];
    }

    public void add(int key) {
        int primaryHash = getPrimaryHash(key);
        if(this.data[primaryHash]==null){
            this.data[primaryHash] = new boolean [secondarySize];
        }
        int secondaryHash = getSecondaryHash(key);
        this.data[primaryHash][secondaryHash] = true;
    }

    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if(this.data[primaryHash]==null){
            return ;
        }
        int secondaryHash = getSecondaryHash(key);
        this.data[primaryHash][secondaryHash] = false;
    }

    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        if(this.data[primaryHash]==null){
            return false;
        }
        int secondaryHash = getSecondaryHash(key);
        return  this.data[primaryHash][secondaryHash];

    }

    public int getPrimaryHash(int key){
        return key/this.primarySize;
    }
    public int getSecondaryHash(int key){
        return key%this.secondarySize;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */