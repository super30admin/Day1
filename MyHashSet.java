/*
 Time Complexity : O(1)
 Space Complexity : O(N) worst case N = 100001
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Help needed in
 for the problem and then implemented the solution after thorough understanding

 Implemented the double hashing technique discussed in class. First, declare an outer array of size 1000
 and only when a key is to be inserted into a specific index, we create another static array of size 1000
 to add the elements into it.
 */

public class MyHashSet {
    boolean[][] data;
    int outerArraySize, innerArraySize;

    public MyHashSet() {
        this.outerArraySize = 1000;
        this.innerArraySize = 1000;
        this.data = new boolean[outerArraySize][];
    }

    private int outerIndexHashFunction(int key) {
        return key%1000;
    }

    private int innerIndexHashFunction(int key) {
        return key/1000;
    }

    public void add(int key) {
        int outerIndex = outerIndexHashFunction(key);
        int innerIndex = innerIndexHashFunction(key);
        if(data[outerIndex] == null) {
            if(outerIndex == 0) {
                data[outerIndex] = new boolean[innerArraySize+1];
            }
            else {
                data[outerIndex] = new boolean[outerArraySize];
            }
        }
        data[outerIndex][innerIndex] = true;
    }

    public void remove(int key) {
        int outerIndex = outerIndexHashFunction(key);
        int innerIndex = innerIndexHashFunction(key);
        if(data[outerIndex] == null) return;
        data[outerIndex][innerIndex] = false;
    }

    public boolean contains(int key) {
        int outerIndex = outerIndexHashFunction(key);
        int innerIndex = innerIndexHashFunction(key);
        if(data[outerIndex] == null) return false;
        System.out.println("The key is in data: " + data[outerIndex][innerIndex]);
        return data[outerIndex][innerIndex];
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