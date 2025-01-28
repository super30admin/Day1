public class MyHashSet {

        private boolean[][] storage;
        private int bucket;
        private int items;

        public MyHashSet() {
            this.bucket = 1000;
            this.items = 1000;
            this.storage = new boolean[bucket][];
        }

        private int hash1(int key){
            return key % bucket;
        }

        private int hash2(int key){
            return key / items;
        }

        public void add(int key) {
            int bucket = hash1(key);
            if(storage[bucket] == null){
                if(bucket == 0){
                    storage[bucket] = new boolean[items + 1];
                }else{
                    storage[bucket] = new boolean[items];
                }
            }
            int item = hash2(key);
            storage[bucket][item] = true;
        }

        public void remove(int key) {
            int bucket = hash1(key);
            if(storage[bucket] == null) {return;}

            int item = hash2(key);
            storage[bucket][item] = false;
        }

        public boolean contains(int key) {
            int bucket = hash1(key);
            if(storage[bucket] == null){ return false;}
            int item = hash2(key);
            return storage[bucket][item];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



/*
Time Complexity -> O(1) for all functions
Space Complexity -> O(n)*/

