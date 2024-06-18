// Time Complexity : O(1)
// Space Complexity : O(N)  Because of the Linked List??
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not Really


// Your code here along with comments explaining your approach

class MyHashSet {
    // List of LinkedLists to handle collisions via separate chaining
    ArrayList<LinkedList<Integer>> buckets;

    public MyHashSet() {
        // Size of the bucket array
        int size = 1000;
        // Initialize the buckets array with the specified size
        buckets = new ArrayList<>(size); 
        // Create and add a new LinkedList for each bucket
        for (int i = 0; i < size; i++) {
            buckets.add(new LinkedList<Integer>()); // Initializing all the buckets
        }
    }

    // Method to add a key to the HashSet
    public void add(int key) {
        int index = hash(key); // Compute the hash to get the index
        LinkedList<Integer> list = buckets.get(index); // Get the bucket at the computed index
        // Add the key to the bucket if it's not already present
        if (!list.contains(key)) {
            list.add(key);
        } 
    }

    // Method to remove a key from the HashSet
    public void remove(int key) {
        int index = hash(key); // Compute the hash to get the index
        LinkedList<Integer> list = buckets.get(index); // Get the bucket at the computed index
        // Remove the key from the bucket
        list.remove(Integer.valueOf(key));
    }

    // Method to check if a key is present in the HashSet
    public boolean contains(int key) {
        int index = hash(key); // Compute the hash to get the index
        LinkedList<Integer> list = buckets.get(index); // Get the bucket at the computed index
        // Check if the key is present in the bucket
        return list.contains(key);
    }

    // Hash function to compute the bucket index
    private int hash(int key) {
        return key % 1000; // Return the index within the range [0, 999]
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */