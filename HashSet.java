// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No doubts

class MyHashSet {
    
    int buckets;
    int bucketItems;
    boolean[][] arr;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.arr = new boolean[this.buckets][];
    }

    public void add(int key) {
        int primaryArr_num = key % buckets;
        int secondaryArr_num = key / bucketItems;

        if(arr[primaryArr_num] == null){
            if(primaryArr_num == 0){
                arr[primaryArr_num] = new boolean[bucketItems + 1];
            } else {
                arr[primaryArr_num] = new boolean[bucketItems];
            }
        }
        arr[primaryArr_num][secondaryArr_num] = true;
    }

    public void remove(int key) {
        if(contains(key)){
            int primaryArr_num = key % buckets;
            int secondaryArr_num = key / bucketItems;

            arr[primaryArr_num][secondaryArr_num] = false;

        }
    }

    public boolean contains(int key) {
        int primaryArr_num = key % buckets;
        int secondaryArr_num = key / bucketItems;
        if(arr[primaryArr_num] == null){
            return false;
        }
        return arr[primaryArr_num][secondaryArr_num];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */