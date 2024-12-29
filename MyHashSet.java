// Time Complexity : O(1)
// Space Complexity : O()
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//We will be using double hashing technique to implemnt hashset
//we will have 2d boolean matrix to store the values of hashset

class MyHashSet{
    int buckets;
    int bucketItems;
    boolean[][] storage;

   public MyHashSet() {
      this.buckets=1000;
      this.bucketItems=1000;
      this.storage=new boolean[buckets][];
       
   }

   public int getBucket(int key){
       return key%buckets;
   }

    public int getBucketItem(int key){
       return key/buckets;
   }

    public void add(int key) {
       int bucket = getBucket(key);
       int bucketItem=getBucketItem(key);
       if(storage[bucket]==null){
           if(bucket==0)
             storage[bucket]= new boolean[this.bucketItems+1];
           else
             storage[bucket]= new boolean[this.bucketItems];
      }
             storage[bucket][bucketItem]= true;				
       
   }
   
   public void remove(int key) {
       int bucket = getBucket(key);
       int bucketItem=getBucketItem(key);
       if(storage[bucket]==null)
         return;
       else
          storage[bucket][bucketItem]=true;
   }
   
   public boolean contains(int key) {
       int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);
       if(storage[bucket]==null){
           return false;
       }
       return storage[bucket][bucketItem];    

   }
}

