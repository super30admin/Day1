// Time Complexity : add, remove and contains-> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : forgot to inclue edge case for 0 and later added it


class HashSet {

    private boolean[][] storage;
    private int primary;
    private int nested;

    private int hashPrimary(int key){


        return key%primary;
    }

  private int hashSecondary(int key){


        return key/nested;
    }

    public MyHashSet() {   

        this.primary=1000;
        this.nested=1000;
        this.storage=new boolean[primary][];

    }
    
    public void add(int key) {

        int bucket = hashPrimary(key);
        if(storage[bucket] == null){
            if(bucket==0){
                storage[bucket]=new boolean[nested+1];
            }
              else{
             storage[bucket]=new boolean[nested];

                }


        }

        int bucketItem = hashSecondary(key);
        storage[bucket][bucketItem]=true;
        
        
    }
    
    public void remove(int key) {

        int bucket = hashPrimary(key);
        if(storage[bucket]==null){

            return ;
        }
        else{

            int bucketItem=hashSecondary(key);
            storage[bucket][bucketItem]=false;
        }

        
    }
    
    public boolean contains(int key) {
                int bucket = hashPrimary(key);
                  if(storage[bucket]==null){
                     return  false;
                   }
        else{
            int bucketItem=hashSecondary(key);
            return storage[bucket][bucketItem];
        }


        
    }
}

