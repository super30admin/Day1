/*
    1. Time Complexity : For operations add, remove, contains - O(1)
    2. Space Complexity : O(n)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Created a boolean array of size 10**6
 * where arr[index] == True represents  key(==index) is present in the set.
 */

class HashSet {
    int size = 1_000_001;
    boolean[] arr;

    HashSet() {
        arr = new boolean[size];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }

}

/*
    1. Time Complexity :
            For operations add, remove, contains :
                Averag Case: O(n/m) where n is total number of keys, m is number of buckets
                Worst case:  O(n) when all the keys fall in the same index.
    2. Space Complexity : O(n)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Created an array of linked lists to implement linear chaining.
 * The index of key is determined by hash_function and key is added to the linked list at that index.
 * To retreive/delete a key, find the index by hash(key) and iterate the linked list to find the key.
 */

class HashSetWithLinearChaining {
    class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    Node[] arr;
    int size;

    public HashSetWithLinearChaining() {
        size = 10001;
        arr = new Node[size];
        for (int i = 0;i < size; ++i) {
            arr[i] = null;
        }
    }

    public int hash(int key) {
        return key / 100;
    }

    public void add(int key) {
        int idx = hash(key);
        if (!contains(key)) {
            arr[idx] = new Node(key, arr[idx]);
        }
    }

    public boolean contains(int key) {
        Node curr = arr[hash(key)];
        while (curr != null) {
            if (curr.data == key) return true;
            curr = curr.next;
        }
        return false;
    }

    public void remove(int key) {
        int idx = hash(key); 
        Node curr = arr[idx], prev = null;
        while (curr != null) {
            if (curr.data == key) {
                if (prev == null)
                    arr[idx] = arr[idx].next;
                else
                    prev.next = curr.next;
                curr.next = null;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

    }
}
class Solution {
    public static void main(String[] args) {
        System.out.println("Hash Set");
        HashSet set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(1_000_000);
        set.add(0);
        System.out.println(set.contains(0));
        System.out.println(set.contains(1_000_000));
        System.out.println(set.contains(3));
        set.remove(1_000_000);
        System.out.println(set.contains(1_000_000));

        System.out.println("Hash Set with Chaining");

        HashSetWithLinearChaining hashset = new HashSetWithLinearChaining();
        hashset.add(1);
        hashset.add(2);
        hashset.add(1_000_000);
        hashset.add(10000);
        hashset.add(10001);
        System.out.println(hashset.contains(0));
        System.out.println(hashset.contains(1_000_000));
        System.out.println(hashset.contains(10000));
        hashset.remove(10000);
        System.out.println(hashset.contains(10000));
    }
}
