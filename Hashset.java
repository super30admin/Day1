// Time Complexity : O(1) 
// Space Complexity : O(1)
class MyHashSet {
private boolean[] hashSet;

    public MyHashSet() {
        hashSet = new boolean[1000001];
        Arrays.fill(hashSet, false);
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    public boolean contains(int key) {
        return hashSet[key];
    }
}
