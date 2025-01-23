// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i have faced some syntax issues later i was able to resolve


// Your code here along with comments explaining your approach
// i have implemented hashset using 2D array i.e primary array of size buckets
class MyHashSet {
    boolean[][] storage;
       int buckets; // maximum length of primary array
       int bucketItems; // maximum length of secondary array
      
       public MyHashSet() {
            
            this.buckets=1000;
            this.bucketItems=1000;
            storage = new boolean[buckets][];  //Initialize primary array of size buckets
       }
        int hash1(int key){
             return key % buckets;
       }
        int hash2(int key){
             return key / bucketItems;
          
       }
       public void add(int key) {
            int bucketIndex = hash1(key);
           if(storage[bucketIndex] == null){
               if(bucketIndex == 0 ){
                   storage[bucketIndex] = new boolean[bucketItems + 1];
               }else{
                   storage[bucketIndex] = new boolean[bucketItems];
               }
           }
           int bucketItemIndex = hash2(key);
           storage[bucketIndex][bucketItemIndex] = true;
           
       }
       
       public void remove(int key) {
            int bucketIndex = hash1(key);
             if(storage[bucketIndex] != null){
              int bucketItemIndex=hash2(key);
              storage[bucketIndex][bucketItemIndex] = false;
       }
       }
       
       public boolean contains(int key) {
            int bucketIndex = hash1(key);
             if(storage[bucketIndex] != null){
              int bucketItemIndex=hash2(key);
             return storage[bucketIndex][bucketItemIndex];
             }
             return false;
       }
   }
   
   /**
    * Your MyHashSet object will be instantiated and called as such:
    * MyHashSet obj = new MyHashSet();
    * obj.add(key);
    * obj.remove(key);
    * boolean param_3 = obj.contains(key);
    */