// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class HashSet {
    //given constraints as 10^6.
    private int array_size = 1000001;
    private boolean[] buckets;

    public HashSet() {
        buckets = new boolean[array_size];
    }

    public void add(int key) {
        buckets[key]  =  true;
    }

    public void remove(int key) {
        buckets[key] = false;
    }

    public boolean contains(int key) {
        return buckets[key];
    }
}