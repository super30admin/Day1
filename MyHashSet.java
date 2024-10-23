// Time Complexity : add: O(1)
//                   remove: O(1)
//                   contains:O(1)
// Space Complexity :Constructor O(n)
//                   add: O(1)
//                   remove: O(1)
//                   contains:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : (initially I was not understanding remove function
//                                              then when I debugged it I understood its making the key as false even though its false already as i want to print it i changed the code accordingly)

class MyHashSet {
    int pBucket;
    int sBucket;
    boolean[][] storage;

    public MyHashSet() {
        this.pBucket=1000;  //square root of 1000000
        this.sBucket=1000;  //square root of 1000000
        this.storage= new boolean[pBucket][];
    }

    //adding a key to the HashSet
    public void add(int key) {
        int pIndex = key % pBucket;
        if(storage[pIndex]==null){
            if(pIndex == 0){
                storage[pIndex]= new boolean[sBucket+1];
            } else {
                storage[pIndex]= new boolean[sBucket];
            }
        }
        int sIndex= key/sBucket;
        storage[pIndex][sIndex]=true;
        System.out.println(key+" added to MyHashSet");
    }

    //adding a key to the HashSet
    public void remove(int key) {
        int pIndex = key % pBucket;
        if(storage[pIndex]==null){
           System.out.println(key+" doesn't exists in MyHashSet");
           return;
        }
        int sIndex= key/sBucket;
        if(storage[pIndex][sIndex]){
            storage[pIndex][sIndex]=false;
            System.out.println(key+" is removed from the MyHashSet");
        } else {
            System.out.println(key+" doesn't exists in MyHashSet");
        }
    }

    //To check whther hashset contains  a key
    public boolean contains(int key) {
        int pIndex = key % pBucket;
        if(storage[pIndex]==null){
            return false;
        }
        int sIndex= key/sBucket;
         return storage[pIndex][sIndex];
    }


    public static void main(String[] args) {
        /* Start with the empty list. */
        MyHashSet hashSet = new MyHashSet();

        hashSet.add(2001);
        hashSet.add(1000000);
        hashSet.add(2002);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(7);
        hashSet.add(10);
        hashSet.add(89);
        hashSet.add(90);

        hashSet.remove(10);
        hashSet.remove(2002);
        hashSet.remove(2005);

        int key =2001;
        if (hashSet.contains(key)) {
            System.out.print("My hashSet contains "+ key);
        } else {
            System.out.print("My hashSet doesn't contain "+ key);
        }
    }
}


