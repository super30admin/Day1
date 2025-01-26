// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
//yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    int[][] arr;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.arr = new int[buckets][];
    }

    int hash1(int k) {
        return k % buckets;
    }

    int hash2(int k) {
        return k / bucketItems;
    }

    public void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        // Initialize the bucket if it's null
        if (arr[h1] == null) {
            if (h1 == 0) {
                arr[h1] = new int[bucketItems + 1]; // Special case for 10^6
            } else {
                arr[h1] = new int[bucketItems];
            }
            for (int i = 0; i < arr[h1].length; i++) {
                arr[h1][i] = -1;
            }

        }


        arr[h1][h2] = key;
    }

    public void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        if (arr[h1] == null) {
            return; // Key doesn't exist
        }
        arr[h1][h2] = -1; // Mark as removed
    }

    public boolean contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        if (arr[h1] == null) {
            return false; // Key doesn't exist
        }
        else if(arr[h1][h2]==key){
            return true;
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
