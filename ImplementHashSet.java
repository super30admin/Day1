// Time Complexity :
// add - O(1)
// remove - O(1)
// contains - O(1)
// Space Complexity : O(n), where n is the input range (worst case)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    // Storage to store inputs. Boolean to reduce space usage
    boolean[][] storage;
    int baseArraySize;
    int subArraySize;

    public MyHashSet() {
        this.baseArraySize = 1000;
        this.subArraySize = 1001;
        // Declare base array only. Sub arrays can be defined once a number belonging to that some array is added
        // thus, Uses storage space efficiently
        this.storage = new boolean[baseArraySize][];
    }

    public int getHashKeyBase(int key) {
        return key%this.baseArraySize;
    }

    public int getHashKeySub(int key) {
        return key/this.subArraySize;
    }

    public void add(int key) {
        int baseArrayIndex = getHashKeyBase(key);
        int subArrayIndex = getHashKeySub(key);

        // If base storage array is null, the subarray and number both wont exist. Hence
        // define subarray of required size first.
        if (storage[baseArrayIndex] == null) {
            storage[baseArrayIndex] = new boolean[this.subArraySize];
        }
        // mark true in subarray at computed position for number, indicating the number is added in appropriate position
        storage[baseArrayIndex][subArrayIndex] = true;
    }

    public void remove(int key) {
        int baseArrayIndex = getHashKeyBase(key);
        int subArrayIndex = getHashKeySub(key);

        // If base storage array is null, the subarray is not present, hence, the number does not exist. So return
        if (storage[baseArrayIndex] == null) {
            return;
        }
        // else return whats stored at subarray at computed position for the key. If true, mark it false, else its false by default.
        storage[baseArrayIndex][subArrayIndex] = false;
    }

    public boolean contains(int key) {
        int baseArrayIndex = getHashKeyBase(key);
        int subArrayIndex = getHashKeySub(key);

        // If base storage array is null, the subarray is not present, hence, the number does not exist. So return false
        if (storage[baseArrayIndex] == null) {
            return false;
        }
        return storage[baseArrayIndex][subArrayIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */