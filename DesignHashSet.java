import java.util.*;

//There are 2 approaches for this problem that I have solved. Please comment / uncomment accordingly

// Time Complexity: O(n) in a worst case
// Space Complexity: O(n) as I've used ArrayList Collection
// I used arrayList here converting keys to strings which needs to be added. 
// On leetcode, the runtime of this approach's is much larger than the mathematical based.
// I am guessing its because, I've used ArrayList, the operations like add, remove and contains
// takes time to execute all operations.

/* class MyHashSet {
    List<String> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!list.contains(String.valueOf(key)))
            list.add(String.valueOf(key));
    }

    public void remove(int key) {
        if (!list.isEmpty() && list.contains(String.valueOf(key))) {
            list.remove(String.valueOf(key));
        }
    }

    public boolean contains(int key) {
        return list.contains(String.valueOf(key));
    }
} */

// Time Complexity: O(1) as it based on mathematical operation rather than looping
// Space Complexity: O(n) as 2D array is being utilized
class MyHashSet {

    int bucketNumber;
    int bucketItemNumber;
    boolean hashSet[][];

    public MyHashSet() {
        this.bucketNumber = 1000;
        this.bucketItemNumber = 1000;
        hashSet = new boolean[this.bucketNumber][];
    }

    int getBucketNumber(int key) {
        return key % this.bucketNumber;
    }

    int getBucketItemNumber(int key) {
        return key / this.bucketItemNumber;
    }

    public void add(int key) {
        int bucket = getBucketNumber(key);
        int bucketItem = 0;
        if (hashSet[bucket] == null) {
            bucketItem = getBucketItemNumber(key);
            hashSet[bucket] = bucket == 0 ? new boolean[bucketItemNumber + 1] : new boolean[bucketItemNumber];
        }
        hashSet[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucketNumber(key);
        int bucketItem = 0;
        if (hashSet[bucket] != null) {
            bucketItem = getBucketItemNumber(key);
            hashSet[bucket][bucketItem] = false;
        }

    }

    public boolean contains(int key) {
        int bucket = getBucketNumber(key);
        int bucketItem = 0;
        if (hashSet[bucket] == null) {
            bucketItem = getBucketItemNumber(key);
            return false;
        }
        return hashSet[bucket][bucketItem];
    }
}

public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(1));
        System.out.println(obj.contains(3));
        obj.add(2);
        System.out.println(obj.contains(2));
        obj.remove(2);
        System.out.println(obj.contains(2));
    }

}