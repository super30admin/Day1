// Time complexity : all the operations are O(1)

 class DoubleHshing {
	    int primaryBuckets;
	    int secondaryBuckets;
	    boolean[][] storage;

	    public DoubleHshing() {
	        this.primaryBuckets = 1000;
	        this.secondaryBuckets = 1000;
	        this.storage = new boolean[primaryBuckets][];// here we are initializing only the primary buckets because we are not certain if we would need secondary buckets for all indices and this would ensure that secondary buckets are created when there are elements to be added at that particular primary index.

	    }

	    private int getPrimaryIndex(int key){
	        return key%primaryBuckets;
	    }
	    private int getSecondaryIndex(int key){
	        return key/secondaryBuckets;
	    }

	    public void add(int key) {
	        if(contains(key)) return;
	        int primary = getPrimaryIndex(key);
	        if(storage[primary] == null){
	            if(primary == 0){
	                storage[primary] = new boolean[secondaryBuckets+1];
	            }
	            else storage[primary] = new boolean[secondaryBuckets];
	        }
	        int secondary = getSecondaryIndex(key);
	        storage[primary][secondary] = true;
	    }

	    public void remove(int key) {
	        int primary = getPrimaryIndex(key);
	        if(storage[primary] == null){
	            return;
	        }
	        else{
	            int secondary = getSecondaryIndex(key);
	            storage[primary][secondary] = false;
	        }

	    }

	    public boolean contains(int key) {
	        int primary = getPrimaryIndex(key);
	        if(storage[primary]==null){
	            return false;
	        }
	        else{
	            int secondary = getSecondaryIndex(key);
	            return storage[primary][secondary];
	        }

	    }
	}