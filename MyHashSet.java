// Approach: An array of linkedlists is used as buckets to store keys of the set.
// Each key is hashed using mod function to get the index of array. After
// obtaining the index, the key is added to corresponsing linkedlist(bucket) at that index.
// Time Complexity : O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.List;
public class MyHashSet {
    private LinkedList<Integer>[] listArr;
    int BUCKET_CNT = 1000;
    @SuppressWarnings("unchecked")
    public MyHashSet() {
        listArr = new LinkedList[BUCKET_CNT];
        for (int i = 0; i < BUCKET_CNT; i++) {
            listArr[i] = new LinkedList<>();
        }
    }
    private int hash(int val) {
        return (val % BUCKET_CNT);
    }

    public void add(int key) {
        int bucketIdx = hash(key);
        if (!contains(key)) {
            listArr[bucketIdx].add(key);
        }
    }

    public void remove(int key) {
        int bucketIdx = hash(key);
        if (contains(key)) {
            listArr[bucketIdx].remove(listArr[bucketIdx].indexOf(key));
        }
    }
    public boolean contains(int key) {
        int bucketIdx = hash(key);
        return listArr[bucketIdx].contains(key);
    }

    void printHashSet() {
        for (LinkedList<Integer> ll : listArr) {
            for (int i : ll) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(10);
        System.out.println("HashSet elements after adding 10 ..");
        hs.printHashSet();
        hs.add(10);
        System.out.println("HashSet elements after adding another 10 ..");
        hs.printHashSet();
        hs.add(20);
        System.out.println("HashSet elements after adding 20 ..");
        hs.printHashSet();
        hs.add(30);
        System.out.println("HashSet elements after adding 30 ..");
        hs.printHashSet();
        hs.remove(10);
        System.out.println("HashSet elements after removing 10 ..");
        hs.printHashSet();
        hs.remove(10);
        System.out.println("HashSet elements after removing 10 again ..");
        hs.printHashSet();
    }
}