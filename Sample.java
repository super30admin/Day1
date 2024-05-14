// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Using seperate chaining method for addition, removal, lookup of elements in a HashSet
 *
 * Time Complexity: O(1) (add, hash), O(n) (remove, contains)
 * Space Complexity: O(n)
 */
class MyHashSet {

    int size;
    LinkedList<Integer>[] arr;

    /**
     * initializing size and the the LinkedList array with size+1
     */
    public MyHashSet() {
        size = (int)Math.pow(10,6); //the max range in the problem statement
        arr = new LinkedList[size+1];
    }

    /**
     * Add the value int the set if not present in the set
     * @param key
     *
     */
    public void add(int key) {


        if(!contains(key)) {
            int index = hash(key);
            if(arr[index] == null){
                arr[index] = new LinkedList<Integer>();
            }

            arr[index].add(key);
        }


    }

    /**
     * Removes the value from the set if present
     * @param key
     *
     */
    public void remove(int key) {

        if(contains(key)) {
            int index = hash(key);
            arr[index].remove((Integer)key);
        }

    }

    /**
     *
     * @param key
     * @return boolean If true, the value already contains in the set,else false
     */
    public boolean contains(int key) {

        int index = hash(key);

        if(arr[index] == null || !arr[index].contains(key)) {
            return false;
        }

        return true;
    }


    /**
     * @param key
     * @return the hash index for the key
     */
    public int hash(int key){

        int index = key%size;
        return index;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */