/**
 * Using boolean array matrix as Jaspinder explained in the class
 * Using 2 hashing algos, and initiating secondary array only if required.
 * Time Complexity : O(1)
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 */

class MyHashSet {

 boolean[][] buckets;
 int n = 1001;
 
    public MyHashSet() {
       buckets = new boolean[n][];
    }
    
    public void add(int key) {
    int firstKeyHash = firstHash(key);
    int secondKeyHash = secondHash(key);
       if(buckets[firstKeyHash] == null){
        buckets[firstKeyHash] = new boolean[n];
       }
     buckets[firstKeyHash][secondKeyHash] = true;
    }
    
   public void remove(int key) {
      int firstKeyHash = firstHash(key);
      int secondKeyHash = secondHash(key);
      if(buckets[firstKeyHash] == null){
        return;
       }
      else{
        buckets[firstKeyHash][secondKeyHash] = false;
      }
    }
    
    public boolean contains(int key) {
      int firstKeyHash = firstHash(key);
      int secondKeyHash = secondHash(key);
      if(buckets[firstKeyHash] == null){
        return false;
       }
      else if(buckets[firstKeyHash][secondKeyHash] == true){
        return true;
      }
      return false;
    }
    
    public int firstHash(int num){
      return num % n;
    }

    public int secondHash(int num){
      return num / n;
    }

}

