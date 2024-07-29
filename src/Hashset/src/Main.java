// Time Complexity :O(1)-Amortised
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class Main {
    private boolean[][] storage;
    int bucket;
    int bucketItems;
    public Main() {
        this.bucket = 1000;
        this.bucketItems=1000;
        this.storage = new boolean[bucket][bucketItems];
    }
    private int bucket(int key){
        return key % bucket;
    }
    private int bucketItem(int key){
        return key / bucketItems;
    }
    public void insert(int key){
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null){
          if(bucket==0){
              storage[bucket]=new boolean[bucketItems + 1];
          }else{
              storage[bucket]=new boolean[bucketItems];
          }
        }
        storage[bucket][bucketItem]=true;
    }
    public void remove(int key){
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return;
        else{
            storage[bucket][bucketItem]=false;
        }
    }
    public boolean contains(int key){
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.insert(1);
        main.insert(2);
        main.insert(3);
        main.insert(4);
        main.remove(2);
       System.out.println(main.contains(1));

    }
}