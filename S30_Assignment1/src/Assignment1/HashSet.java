package Assignment1;
import java.util.Arrays;
import java.util.LinkedList;
 
/* Time Complexity : For all the operations - best/average case T.C = O(1) as we are using hash method to fetch the index of the array.
 * but if there are more elements assigned at that index, the worst case would be having O(n) time complexity.
 * */
/* Space Complexity : As I have taken the initial size of the array as 10^4 the space would be O(n),
 * but if at every index we have multiple elements in the linkedlist say 'm' then the space complexity will be O(n*m)
 * */
// Did this code successfully run on Leetcode : yes, it is accepted.
// Any problem you faced while coding this : during linkedlist array initialization, as I am using it for first time.



// Your code here along with comments explaining your approach

public class HashSet {
		/*took the capacity as 10001, as in the constraints, it is specified that the maximum number of operations
		 * as 10^4, assumed that every operation is an addition.
		*/
		int capacity = 10001;
		/* I followed the chaining approach, where collisions are handled by storing the collided elements in the linkedlist at every index*/
		LinkedList<Integer>[] hashset;
		
	    public HashSet() {
	        hashset = new LinkedList[capacity];
	        Arrays.fill(hashset, new LinkedList<>());
	    }
	    //returns the hash value of the key which represents the index of the hashset array.
	    private int hash(int key)
	    {
	    	return key%capacity;
	    }
	    //add method, gets the index and add it to the linkedlist at that particular index, if the element is not present.
	    public void add(int key) {
	        int index = hash(key);
	        LinkedList<Integer> bucket = hashset[index];
	        if(!bucket.contains(key))
	        	bucket.add(key); 
	    }
	    //remove method, get the index of the key and checks if the element is present in the linkedlist at that particular index, if yes, it removes the element.
	    public void remove(int key) {
	    	int index = hash(key);
	        LinkedList<Integer> bucket = hashset[index];
	        if(bucket.contains(key))
	        	bucket.remove((Integer) key);
	    }
	    //contains, gets the index of the key and checks if present in the linkedlist, if yes, returns true, if no returns false.
	    public boolean contains(int key) {
	    	int index = hash(key);
	        LinkedList<Integer> bucket = hashset[index];
	        if(bucket.contains(key))
	        	return true;
	        return false;
	    }
}
