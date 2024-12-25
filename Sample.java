// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Sample{
    int buckets;
    int bucketItems;
    boolean[][] arr;

    public Sample() {
        this.buckets=1000;
        this.bucketItems=1001;
        this.arr = new boolean[this.buckets][];
    }

    int getBucket(int key){
        return key % this.buckets;
    }

    int getBucketItem(int key){
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(arr[bucket] == null){
            arr[bucket] = new boolean[bucketItems];
        }

        arr[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(arr[bucket]!=null){
            arr[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(arr[bucket]!=null){
            return arr[bucket][bucketItem];
        }

        return false;
    }
}
