package Assignment1;
import java.util.Arrays;
import java.util.LinkedList;
public class HashSet {

		int capacity = 10001;
		LinkedList<Integer>[] hashset;
		
	    public HashSet() {
	        hashset = new LinkedList[capacity];
	        Arrays.fill(hashset, new LinkedList<>());
	    }
	    private int hash(int key)
	    {
	    	return key%capacity;
	    }
	    public void add(int key) {
	        int index = hash(key);
	        LinkedList<Integer> bucket = hashset[index];
	        if(!bucket.contains(key))
	        	bucket.add(key); 
	    }
	    
	    public void remove(int key) {
	    	int index = hash(key);
	        LinkedList<Integer> bucket = hashset[index];
	        if(bucket.contains(key))
	        	bucket.remove((Integer) key);
	    }
	    
	    public boolean contains(int key) {
	    	int index = hash(key);
	        LinkedList<Integer> bucket = hashset[index];
	        if(bucket.contains(key))
	        	return true;
	        return false;
	    }

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
