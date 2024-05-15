class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] arr;
    public MyHashSet() {
        this.buckets=1000;  // key exist from 0 to 10^6 so we took sqaure rrot of 10^6 so its basically list of list with 10^3 respt
        this.bucketItems=1000;
        arr=new boolean[buckets][];
    }
    public int getbucket(int key)
    {
        return key % buckets;
    }
    public int getbucketItem(int key)
    {
        return key / bucketItems;
    }
    public void add(int key)
    {
        int bucket= getbucket(key);
        int bucketItem= getbucketItem(key);
        if(arr[bucket]==null)
        {
            if(bucket==0) // if 10^6/1000=1000 and we are assigning array of 0 to 999 so we cant store 1000 index element so we increased size by 1
            {
                arr[bucket]=new boolean[bucketItems+1];
            }
            else
            {
                arr[bucket]= new boolean[bucketItems];
            }
        }
        arr[bucket][bucketItem]=true;
    }

    public void remove(int key) {
        int bucket= getbucket(key);
        int bucketItem= getbucketItem(key);
        if(arr[bucket]==null)
        {
            return;
        }
        arr[bucket][bucketItem]=false;
    }

    public boolean contains(int key) {
        int bucket= getbucket(key);
        int bucketItem= getbucketItem(key);
        if(arr[bucket]==null)
        {
            return false;
        }
        return arr[bucket][bucketItem];
    }
    public static void main(String args[])
    {
        MyHashSet obj = new MyHashSet();
          obj.add(5);
          obj.remove(5);
          boolean param_3 = obj.contains(5);
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */