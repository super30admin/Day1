// Time Complexity : add, remove and contains O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes after adding the condition for 0th index
// Any problem you faced while coding this : java.lang.ArrayIndexOutOfBoundsException: Index 1000 out of bounds for length 1000


// Your code here along with comments explaining your approach

import java.util.Arrays;
import java.util.Stack;

class Sample {
    public static void main(String[] args) {

        Sample myHasSet = new Sample();
        myHasSet.add(100);
        myHasSet.add(1001);
        myHasSet.add(10001);
        myHasSet.add(20001);
        myHasSet.add(24001);
        myHasSet.add(34001);

        myHasSet.contains(34001);
        myHasSet.contains(24001);
        myHasSet.contains(111);
        myHasSet.remove(111);
        myHasSet.remove(34001);
    }

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    @Override
    public String toString() {
        return "Sample{" +
                "storage=" + Arrays.toString(storage) +
                ", buckets=" + buckets +
                ", bucketItems=" + bucketItems +
                '}';
    }

    private int getBucketNo(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public Sample() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    public void add(int key) {

        int bucketNo = getBucketNo(key);

        if (storage[bucketNo] == null) {

            if (bucketNo == 0) {
                storage[bucketNo] = new boolean[bucketItems + 1];
            } else {
                storage[bucketNo] = new boolean[bucketItems];
            }
        }

        int bucketItemNo = getBucketItem(key);

        storage[bucketNo][bucketItemNo] = true;
    }

    public void remove(int key) {
        int bucketNo = getBucketNo(key);

        if (storage[bucketNo] == null) {
            return;
        }

        int bucketItemNo = getBucketItem(key);

        storage[bucketNo][bucketItemNo] = false;
    }

    public boolean contains(int key) {

        int bucketNo = getBucketNo(key);

        if (storage[bucketNo] == null) {
            return false;
        }

        int bucketItemNo = getBucketItem(key);

        return storage[bucketNo][bucketItemNo];
    }

}