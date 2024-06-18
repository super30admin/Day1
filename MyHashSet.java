/*
 Time Complexity : O(1)
 Space Complexity : O(N) where N = 1000001
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Help needed in
 for the problem and then implemented the solution after thorough understanding

 Used an array data structure of size 1000001(which can accommodate all the integer keys)
 to design the hashset where the index is the key and the bool value present in those indices
 represent if a key is present. If the value is true, a key is present and if it is false, it is not present.
 */

public class MyHashSet {
    boolean[] data;
    public MyHashSet() {
        data = new boolean[1000001];
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    public boolean contains(int key) {
        System.out.println(data[key]);
        return data[key];
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(10);
        myHashSet.add(5);
        myHashSet.contains(20);
        myHashSet.contains(5);
        myHashSet.remove(5);
        myHashSet.contains(5);
    }
}
