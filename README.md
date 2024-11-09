# Design-1

## Design HashSet:
https://leetcode.com/problems/design-hashset/description/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Double Hashing


# Approach
<!-- Describe your approach to solving the problem. -->
First hash function is used for primary array that holds references to secondary array. We will call each location in primary array as bucket.

Secondary boolean array stores if the value is present in the hashSet or not. We will call each location in secondary array as positionInBucket.

We will initialize the primary array in the constructor. Secondary arrays are initiated on the go while putting values.

##### Edge Case
For input range of [1,25]
Bucket = 25%5 = 0
PositionInBucket = 25/5 = 5

But secondary array has indices 0 to 4
For this case, when bucket=0, initialize secondary bucket with size+1

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
add() - $$O(1)$$
remove() - $$O(1)$$
contains() - $$O(1)$$

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
add() - $$O(1)$$
remove() - $$O(1)$$
contains() - $$O(1)$$

# Code
```java []
class MyHashSet {

    private boolean[][] hashSet;
    private int size;

    public MyHashSet() {
        this.size = (int) Math.sqrt(Math.pow(10, 6));
        this.hashSet = new boolean[size][];
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int positionInBucket = getPositionInBucket(key);

        if (hashSet[bucket] == null) {
            if (bucket == 0) {
                hashSet[bucket] = new boolean[size + 1];
            } else {
                hashSet[bucket] = new boolean[size];
            }
        }

        hashSet[bucket][positionInBucket] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int positionInBucket = getPositionInBucket(key);

        if (hashSet[bucket] == null) {
            return;
        }

        hashSet[bucket][positionInBucket] = false;

    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int positionInBucket = getPositionInBucket(key);

        if (hashSet[bucket] == null) {
            return false;
        }

        return hashSet[bucket][positionInBucket];
    }

    private int getBucket(int key) {
        return key % size;
    }

    private int getPositionInBucket(int key) {
        return key / size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
````

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)



