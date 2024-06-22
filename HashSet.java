//Time complexity: O(1)
//Spcae Complexity: O(n + m) - where 'n' is the number of elements in the bucket and 'm' is the size of 'INITIAL_SIZE' (1001) which is a constant technically as it has fixed size
import java.util.LinkedList;

class MyHashSet {
    private final int INITIAL_SIZE = 1001;
    private LinkedList<Integer>[] hashTable;

    public MyHashSet() {
        hashTable = new LinkedList[INITIAL_SIZE];

    }

    public void add(int key) {
        int index = linearHash(key);
        if(hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        LinkedList<Integer> bucket = hashTable[index];
        if(!bucket.contains(key)) {
            bucket.add(key);
        }

    }

    public void remove(int key) {
        int index = linearHash(key);
        LinkedList<Integer> bucket = hashTable[index];
        if(bucket != null) {
            bucket.remove((Integer) key);
        }


    }

    public boolean contains(int key) {
        int index = linearHash(key);
        LinkedList<Integer> bucket = hashTable[index];
        return bucket != null && bucket.contains(key);

    }

    private int linearHash(int key) {
        return key % INITIAL_SIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */