public class MyHashSet {
    //T: O(1) S:O(N)

    int bucket;
    int bucketItem;
    boolean[][] set;
    public MyHashSet() {
        bucket = 1000;
        bucketItem = 1000;
        set = new boolean[bucket][];
    }

    public void add(int key) {
        int bucketIndex = key % 1000;
        int bucketItemIndex = key / 1000;
        if(set[bucketIndex] == null){
            if(bucketIndex == 0){
                set[bucketIndex] = new boolean[bucketItem + 1];
            } else {
                set[bucketIndex] = new boolean[bucketItem];
            }
        }
        set[bucketIndex][bucketItemIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = key % 1000;
        int bucketItemIndex = key / 1000;
        if(set[bucketIndex] != null){
            set[bucketIndex][bucketItemIndex] = false;
        }
    }

    public boolean contains(int key) {
        int bucketIndex = key % 1000;
        int bucketItemIndex = key / 1000;
        if(set[bucketIndex] != null){
            return set[bucketIndex][bucketItemIndex];
        } else {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
