/***
 * Time Complexity : o(1)
 * Space Complexity : 0(1000*1000)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : no
 * Creating Hashset using arrays. we intialise to the nearest square root of the size.
 * The Modulo operator gives a looping effect. At the edges for 0 and 1000 as it reaches value of 1000 we increase he size plus 1.
 * Use Double Hashing to avoid hash collision.
 */
class MyHashSet {

    boolean hashSet[][];

    public MyHashSet() {
        hashSet = new boolean[1000][];
    }

    private int getPrimaryHash(int key) {
        return key % 1000;
    }

    private int getSecondaryHash(int key) {
        return key / 1000;
    }

    public void add(int key) {
        if (hashSet[getPrimaryHash(key)] == null) {
            hashSet[getPrimaryHash(key)] = new boolean[getPrimaryHash(key) == 0 || getPrimaryHash(key) == 1000 ? 1001
                    : 1000];
        }
        hashSet[getPrimaryHash(key)][getSecondaryHash(key)] = true;
    }

    public void remove(int key) {
        if (hashSet[getPrimaryHash(key)] == null) {
            return;
        }
        hashSet[getPrimaryHash(key)][getSecondaryHash(key)] = false;
    }

    public boolean contains(int key) {
        if (hashSet[getPrimaryHash(key)] == null) {
            return false;
        }
        return hashSet[getPrimaryHash(key)][getSecondaryHash(key)];
    }

}