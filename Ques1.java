class MyHashSet {
    boolean[] a;

    public MyHashSet() {
        a = new boolean[1000001]; // Allocate space for keys up to 1,000,000.
    }

    public void add(int key) {
        a[key] = true; // Mark the key as present.
    }

    public void remove(int key) {
        a[key] = false; // Mark the key as not present.
    }

    public boolean contains(int key) {
        return a[key]; // Return true if the key is present, false otherwise.
    }
}